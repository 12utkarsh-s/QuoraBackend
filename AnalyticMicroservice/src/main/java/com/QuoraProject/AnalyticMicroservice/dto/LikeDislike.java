package com.QuoraProject.AnalyticMicroservice.dto;

public class LikeDislike {

    String answerID;

    String userId;

    public LikeDislike() {
    }

    public String getAnswerID() {
        return answerID;
    }

    public void setAnswerID(String answerID) {
        this.answerID = answerID;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
