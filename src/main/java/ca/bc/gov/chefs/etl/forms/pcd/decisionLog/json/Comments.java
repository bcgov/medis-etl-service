package ca.bc.gov.chefs.etl.forms.pcd.decisionLog.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import ca.bc.gov.chefs.etl.util.CSVUtil;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Comments {
    public String comment;
    public String commentDate;

    public String getComment() {
        return CSVUtil.replaceCarriageReturnLineFeed(comment);
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = CSVUtil.getFormattedDate(commentDate);
    }
}
