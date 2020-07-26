package com.QuoraProject.AnalyticMicroservice.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.solr.core.mapping.Indexed;
import org.springframework.data.solr.core.mapping.SolrDocument;



@SolrDocument(collection = "answerStatistics")
public class AnswerStatistics {

    @Id
    @Indexed(name = "id",type = "string")
    String answerID;

    @Indexed(name="acceptedFlag", type = "boolean")
    boolean acceptedFlag;

    @Indexed(name = "likeCount",type="int")
    int likeCount;

    @Indexed(name = "dislikeCount",type = "int")
    int dislikeCount;

    public AnswerStatistics() {
        this.acceptedFlag=false;
        this.likeCount=0;
        this.dislikeCount=0;
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public boolean isAcceptedFlag() {
        return acceptedFlag;
    }

    public void setAcceptedFlag(boolean acceptedFlag) {
        this.acceptedFlag = acceptedFlag;
    }

    public int getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public int getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(int dislikeCount) {
        this.dislikeCount = dislikeCount;
    }


    public static Builder getBuilder(String answerID, boolean acceptedFlag, int likeCount,int dislikeCount) {
        return new Builder(answerID, acceptedFlag,likeCount,dislikeCount);
    }


    public static class Builder {
        private AnswerStatistics build;

        public Builder(String answerID, boolean acceptedFlag, int likeCount,int dislikeCount) {
            build = new AnswerStatistics();
            build.answerID = answerID;
            build.acceptedFlag = acceptedFlag;
            build.likeCount=likeCount;
            build.dislikeCount=dislikeCount;
        }

        public AnswerStatistics build() {
            return build;
        }
    }

}
