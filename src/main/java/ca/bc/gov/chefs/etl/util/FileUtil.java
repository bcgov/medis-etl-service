package ca.bc.gov.chefs.etl.util;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.bouncycastle.bcpg.ArmoredOutputStream;

import org.bouncycastle.bcpg.CompressionAlgorithmTags;
import org.bouncycastle.bcpg.SymmetricKeyAlgorithmTags;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPCompressedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedData;
import org.bouncycastle.openpgp.PGPEncryptedDataGenerator;
import org.bouncycastle.openpgp.PGPEncryptedDataList;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.openpgp.PGPPrivateKey;
import org.bouncycastle.openpgp.PGPPublicKeyEncryptedData;
import org.bouncycastle.openpgp.PGPSecretKey;
import org.bouncycastle.openpgp.PGPSecretKeyRingCollection;
import org.bouncycastle.openpgp.PGPUtil;
import org.bouncycastle.openpgp.jcajce.JcaPGPObjectFactory;
import org.bouncycastle.openpgp.operator.jcajce.JcaKeyFingerprintCalculator;
import org.bouncycastle.openpgp.operator.jcajce.JcePBESecretKeyDecryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePGPDataEncryptorBuilder;
import org.bouncycastle.openpgp.operator.jcajce.JcePublicKeyKeyEncryptionMethodGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.supercsv.io.CsvListWriter;
import org.supercsv.io.ICsvListWriter;
import org.supercsv.prefs.CsvPreference;
import org.supercsv.quote.AlwaysQuoteMode;

import ca.bc.gov.chefs.etl.constant.Constants;
import ca.bc.gov.chefs.etl.constant.POLYConstants;
import ca.bc.gov.chefs.etl.core.model.FileProperties;

import static ca.bc.gov.chefs.etl.constant.Constants.HEADERS;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileUtil {

	private static final int compressionAlgorithm = CompressionAlgorithmTags.ZIP;
	private static final int symmetricKeyAlgorithm = SymmetricKeyAlgorithmTags.AES_256;
	private static final boolean armor = true;
	private static final boolean withIntegrityCheck = true;
	private static final int bufferSize = 1 << 16;
	private static final Logger logger = LoggerFactory.getLogger(CSVUtil.class);
	private static final CsvPreference ALWAYS_USE_QUOTE = new CsvPreference.Builder(CsvPreference.STANDARD_PREFERENCE).useQuoteMode(new AlwaysQuoteMode()).build();

	// When this function is made static it causes a series of issues with the PGP library, so we need to keep it as an instance method
	// TODO: Refactor this to be static and remove the instance variables
	public static void encrypt(OutputStream encryptOut, InputStream clearIn, long length, InputStream publicKeyIn) throws IOException, PGPException {
		PGPCompressedDataGenerator compressedDataGenerator = new PGPCompressedDataGenerator(compressionAlgorithm);
		PGPEncryptedDataGenerator pgpEncryptedDataGenerator = new PGPEncryptedDataGenerator(
				// This bit here configures the encrypted data generator
				new JcePGPDataEncryptorBuilder(symmetricKeyAlgorithm).setWithIntegrityPacket(withIntegrityCheck).setSecureRandom(new SecureRandom()).setProvider(BouncyCastleProvider.PROVIDER_NAME));
		// Adding public key
		pgpEncryptedDataGenerator.addMethod(new JcePublicKeyKeyEncryptionMethodGenerator(CommonUtils.getPublicKey(publicKeyIn)));
		if (armor) {
			encryptOut = new ArmoredOutputStream(encryptOut);
		}
		OutputStream cipherOutStream = pgpEncryptedDataGenerator.open(encryptOut, new byte[bufferSize]);
		CommonUtils.copyAsLiteralData(compressedDataGenerator.open(cipherOutStream), clearIn, length, bufferSize);
		// Closing all output streams in sequence
		compressedDataGenerator.close();
		cipherOutStream.close();
		encryptOut.close();
	}

	public static void encryptFilesInDirectory(String directoryPath, String publicKeyFilePath, String outputDirectoryPath, Boolean useZip) throws Exception {
		final String txtExtentesion = "txt";
		// Read the public key from the file
		InputStream publicKeyInputStream = new BufferedInputStream(new FileInputStream(new File(publicKeyFilePath)));

		// Get a list of all the files in the directory
		File dir = new File(directoryPath);
		File[] files = dir.listFiles();

		// Compress and encrypt each file
		for (File file : files) {
			String inputFilePath = file.getAbsolutePath();
			if (FilenameUtils.getExtension(file.getName()).equals(txtExtentesion)) {
				String compressionExtension = useZip ? ".zip" : ".gz";

				String outputFileName = file.getName() + compressionExtension + ".gpg";
				String gzipFileName = file.getName() + compressionExtension;

				String outputFilePath = outputDirectoryPath + "/" + outputFileName;
				String gzipFilePath = outputDirectoryPath + "/" + gzipFileName;
				File outputFile = new File(outputDirectoryPath, outputFileName);
				if (!outputFile.exists()) {
					outputFile.createNewFile();
				}
				if (!new File(outputDirectoryPath, gzipFileName).exists()) {
					new File(outputDirectoryPath, gzipFileName).createNewFile();
				}

				if (useZip) {
					// Compress the file using ZIP
					compressFileZip(inputFilePath, gzipFilePath);
				} else {
					// Compress the file using GZIP
					compressFileGzip(inputFilePath, gzipFilePath);
				}

				InputStream gzipInputStream = new BufferedInputStream(new FileInputStream(gzipFilePath));

				try (OutputStream encryptedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFilePath))) {
					encrypt(encryptedOutputStream, gzipInputStream, file.length(), publicKeyInputStream);
				} catch (IOException e) {
					logger.error("Error encrypting file: " + e.getMessage());
				}
				// Clean up the gzip file
				new File(outputDirectoryPath, gzipFileName).delete();

			} else {
				File outputFile = new File(outputDirectoryPath, file.getName());
				try {
					FileUtils.copyFile(file, outputFile);
				} catch (IOException e) {
					logger.error("Error copying file: " + e.getMessage());
				}
			}
		}
	}

	public static void compressFileZip(String sourceFilePath, String destinationFilePath) {
		byte[] buffer = new byte[1024];

		try {
			ZipOutputStream zipOutputStream;
			try (FileInputStream fileInput = new FileInputStream(sourceFilePath)) {
				FileOutputStream fileOutputStream = new FileOutputStream(destinationFilePath);
				zipOutputStream = new ZipOutputStream(fileOutputStream);
				// ZIP compression (creates a proper .zip file that can be opened with ZIP tools)
				// Create a zip entry for the file (using the filename from the source path)
				String fileName = new File(sourceFilePath).getName();
				ZipEntry zipEntry = new ZipEntry(fileName);
				zipOutputStream.putNextEntry(zipEntry);
				int bytesRead;
				while ((bytesRead = fileInput.read(buffer)) > 0) {
					zipOutputStream.write(buffer, 0, bytesRead);
				}
			}

			zipOutputStream.closeEntry();
			zipOutputStream.finish();
			zipOutputStream.close();
		} catch (IOException ex) {
			logger.error("Error compressing file: " + ex.getMessage());
		}
	}


	public static void compressFileGzip(String sourceFilePath, String destinationFilePath) {
		byte[] buffer = new byte[1024];

		try {
			FileOutputStream fileOutputStream;
			GZIPOutputStream gzipOutputStream;
			try (FileInputStream fileInput = new FileInputStream(sourceFilePath)) {
				fileOutputStream = new FileOutputStream(destinationFilePath);
				gzipOutputStream = new GZIPOutputStream(fileOutputStream);
				int bytes_read;
				while ((bytes_read = fileInput.read(buffer)) > 0) {
					gzipOutputStream.write(buffer, 0, bytes_read);
				}
			}

			gzipOutputStream.finish();
			gzipOutputStream.close();
			fileOutputStream.close();
		} catch (IOException ex) {
			logger.error("Error compressing file: " + ex.getMessage());
		}
	}

	public static List<String> writeToCSVFile(Map<String, List<List<String>>> map, String directoryKey, boolean isHeaderAdded) throws IOException {
		FileProperties fileProperties = new FileProperties();
		fileProperties.setUnEncDirForThisExchange(Constants.UNENC_FILE_PATH.get(directoryKey));
		fileProperties.setEncDirForThisExchange(Constants.ENC_FILE_PATH.get(directoryKey));
		ICsvListWriter listWriter = null;
		List<String> filesGenerated = new ArrayList<String>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		String dateTime = LocalDateTime.now().format(formatter);

		String guidSuffixEnabled = PropertiesUtil.getValue(Constants.GUID_SUFFIX);
		logger.info("GUID suffix enabled: {}", guidSuffixEnabled);
		if (Boolean.parseBoolean(guidSuffixEnabled)) {
			dateTime += "_".concat(java.util.UUID.randomUUID().toString());
		}

		for (Map.Entry<String, List<List<String>>> entry : map.entrySet()) {
			String fileName = generateFileName(entry.getKey(), dateTime, fileProperties);
			String[] headers = HEADERS.get(entry.getKey());
			logger.info("--------Generating CSV File---------------{}---------------", fileName);
			try {

				listWriter = new CsvListWriter(new FileWriter(fileName), ALWAYS_USE_QUOTE);
				if (isHeaderAdded) {
					listWriter.writeHeader(headers);
				}

				for (List<String> items : entry.getValue()) {
					listWriter.write(items);
				}
				filesGenerated.add(fileName.substring(fileName.lastIndexOf(File.separator) + 1));
			} catch (IOException ex) {
				logger.error("Error writing to CSV file: " + ex.getMessage());
			} finally {
				if (listWriter != null) {
					try {
						listWriter.close();
					} catch (IOException e) {
						logger.error("Error closing CSV writer: " + e.getMessage());
					}
				}
			}

		}
		fileProperties.setExtension(".flag");
		String flagFileName = generateFileName(directoryKey, dateTime, fileProperties);
		File file = new File(flagFileName);
		try (FileWriter fileWriter = new FileWriter(file)) {
			logger.info("--------Generating Flag File---------------{}---------------", flagFileName);
			for (String fileName : filesGenerated) {
				fileWriter.append(fileName);
				fileWriter.append("\n");
			}
			filesGenerated.add(flagFileName.substring(flagFileName.lastIndexOf(File.separator) + 1));
		} catch (IOException e) {
			logger.error("Error writing to flag file: " + e.getMessage());
		}
		try {
			encryptAllFiles(dateTime, fileProperties);
		} catch (Exception e) {
			logger.error("Error encrypting files: " + e.getMessage());
		}
		return filesGenerated;
	}

	/*
	 * This method is destined for testing purposes. Use it if you want to create a file containing the payload coming from CHEFS once it is transformed
	 */
	public static void writeToDirectory(String fileName, String fileContent, String directoryName) {
		// Create the directory if it doesn't exist
		File directory = new File(directoryName);
		if (!directory.exists()) {
			directory.mkdirs();
		}
		File file = new File(directory, fileName);
		try {
			FileWriter fileWriter = new FileWriter(file);
			try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
				bufferedWriter.write(fileContent);
			} 
			System.out.println("Content has been written to " + file.getAbsolutePath());
		} catch (IOException e) {
			logger.error("Error writing to file: " + e.getMessage());
		}
	}

	public static void encryptAllFiles(String dateTime, FileProperties fileProperties) throws Exception {
		String directoryPath = generateFolderName(dateTime, fileProperties.getUnEncDirForThisExchange());
		String outputDirectoryPath = fileProperties.getEncDirForThisExchange();
		String separateLtcAndPcdEncFolder = PropertiesUtil.getValue(Constants.SEPARATE_LTC_AND_PCD_ENC_FOLDERS);

		// Track whether the data is going to the ODS since it uses a different path PGP signing key
		Boolean odsData = Boolean.FALSE;
		Boolean polyData = Boolean.FALSE;

		if (Boolean.parseBoolean(separateLtcAndPcdEncFolder)) {
			logger.info("--------Unencrypted File Name---------------{}---------------", directoryPath);
			if (directoryPath.contains("unencrypted/pcd")) {
				outputDirectoryPath = outputDirectoryPath.concat("/pcd");
			} else if (directoryPath.contains("unencrypted/ltc")) {
				// Route submitted data to the ods
				if (directoryPath.contains("submitted")) {
					outputDirectoryPath = outputDirectoryPath.concat("/ltc-ods");
					odsData = Boolean.TRUE;
				} else {
					outputDirectoryPath = outputDirectoryPath.concat("/ltc");
				}
			} else if (directoryPath.contains("unencrypted/poly")) {
				outputDirectoryPath = outputDirectoryPath.concat("/poly");
				polyData = Boolean.TRUE;
			}
			logger.info("--------Encrypted File Name---------------{}---------------", outputDirectoryPath);
		}

		try {
			Files.createDirectories(Paths.get(directoryPath));
			Files.createDirectories(Paths.get(outputDirectoryPath));
		} catch (IOException e) {
			logger.error("File Write Exception: " + e.getMessage());
		}
		String publicKeyFilePath;
		if (odsData) {
			publicKeyFilePath = Constants.ODS_PUBLIC_KEY_PATH;
		} else if (polyData) {
			publicKeyFilePath = POLYConstants.POLY_PUBLIC_KEY_PATH;
		} else {
			publicKeyFilePath = Constants.PUBLIC_KEY_PATH;
		}
		encryptFilesInDirectory(directoryPath, publicKeyFilePath, outputDirectoryPath, polyData);
	}

	public static String generateFolderName(String dateTime, String directoryName) {
		return directoryName.concat(File.separator).concat(dateTime).replace(File.separator, "/");
	}

	public static String generateFileName(String fileType, String dateTime, FileProperties fileProperties) {
		String directoryForThisExchange = fileProperties.getUnEncDirForThisExchange();
		String directoryPath = directoryForThisExchange.concat(File.separator).concat(dateTime).concat(File.separator);
		try {
			Files.createDirectories(Paths.get(directoryPath));
		} catch (IOException e) {
			logger.error("File Write Exception: " + e.getMessage());
		}
		return directoryPath + fileType.toLowerCase() + "_".concat(dateTime).concat(fileProperties.getExtension());
	}

	public static String buildDestinationPath(String propertyName, boolean isDataEncrypted) {
		if (isDataEncrypted) {
			return PropertiesUtil.getValue(Constants.PROPERTIES_ENC_DATA_DIR);
		}
		return PropertiesUtil.getValue(Constants.PROPERTIES_DATA_DIR) + File.separator + PropertiesUtil.getValue(propertyName);
	}

	public static String buildDirectoryPath(String propertyName) {
		return PropertiesUtil.getValue(propertyName);
	}

	public static String getDirectoryName(String propertyName) {
		return PropertiesUtil.getValue(propertyName);
	}

	public static String buildPublicKeyPath(String propertyName) {
		return PropertiesUtil.getValue(propertyName);
	}

	/**
	 * ----------------decryption starts here, testing encryption ------------------- TODO This part is for testing purposes only, remove when done
	 */

	private static PGPPrivateKey findSecretKey(long keyID) throws Exception, PGPException {
		String privateKeyInPath = PropertiesUtil.getValue(Constants.ENCRYPTION_SECRET_PATH);
		String password = PropertiesUtil.getValue(Constants.ENCRYPTION_SECRET_PWD);
		char[] passCode = password.toCharArray();
		InputStream privateKeyIn = new BufferedInputStream(new FileInputStream(new File(privateKeyInPath)));
		PGPSecretKeyRingCollection pgpSecretKeyRingCollection = new PGPSecretKeyRingCollection(PGPUtil.getDecoderStream(privateKeyIn), new JcaKeyFingerprintCalculator());
		PGPSecretKey pgpSecretKey = pgpSecretKeyRingCollection.getSecretKey(keyID);
		return pgpSecretKey == null ? null : pgpSecretKey.extractPrivateKey(new JcePBESecretKeyDecryptorBuilder().setProvider(BouncyCastleProvider.PROVIDER_NAME).build(passCode));
	}

	public static void decrypt(InputStream encryptedIn, OutputStream clearOut) throws PGPException, IOException, Exception {
		// Removing armour and returning the underlying binary encrypted stream
		encryptedIn = PGPUtil.getDecoderStream(encryptedIn);
		JcaPGPObjectFactory pgpObjectFactory = new JcaPGPObjectFactory(encryptedIn);

		Object obj = pgpObjectFactory.nextObject();
		// The first object might be a marker packet
		PGPEncryptedDataList pgpEncryptedDataList = (obj instanceof PGPEncryptedDataList) ? (PGPEncryptedDataList) obj : (PGPEncryptedDataList) pgpObjectFactory.nextObject();

		PGPPrivateKey pgpPrivateKey = null;
		PGPPublicKeyEncryptedData publicKeyEncryptedData = null;

		Iterator<PGPEncryptedData> encryptedDataItr = pgpEncryptedDataList.getEncryptedDataObjects();
		while (pgpPrivateKey == null && encryptedDataItr.hasNext()) {
			publicKeyEncryptedData = (PGPPublicKeyEncryptedData) encryptedDataItr.next();
			pgpPrivateKey = FileUtil.findSecretKey(publicKeyEncryptedData.getKeyID());
		}

		if (Objects.isNull(publicKeyEncryptedData)) {
			throw new PGPException("Could not generate PGPPublicKeyEncryptedData object");
		}

		if (pgpPrivateKey == null) {
			throw new PGPException("Could Not Extract private key");
		}
		CommonUtils.decrypt(clearOut, pgpPrivateKey, publicKeyEncryptedData);
	}

	public static void decryptAllFiles(String directoryPath, String outputDirectoryPath) throws IOException, PGPException, Exception {
		// Get a list of all the files in the directory
		File dir = new File(directoryPath);
		File[] files = dir.listFiles();
		try {
			Files.createDirectories(Paths.get(outputDirectoryPath));
		} catch (IOException e) {
			logger.error("File Write Exception: " + e.getMessage());
		}

		for (File file : files) {

			// String inputFilePath = file.getAbsolutePath();
			String outputFileName = file.getName().replace(".gpg", "");
			// String outputFilePath = outputDirectoryPath + "/" + outputFileName;
			File outputFile = new File(outputDirectoryPath, outputFileName);
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}

			InputStream encryptedDataInputStream = new BufferedInputStream(new FileInputStream(file));

			OutputStream encryptedOutputStream = new BufferedOutputStream(new FileOutputStream(outputFile));
			FileUtil.decrypt(encryptedDataInputStream, encryptedOutputStream);
			encryptedOutputStream.close();
		}
	}
}
