package com.QuoraProject.QAMicroservice.repository;

import com.QuoraProject.QAMicroservice.entity.Answer;
import com.QuoraProject.QAMicroservice.entity.Comment;

import java.util.List;

public interface CustomQueryRepository {

    List<Answer> fetchAnswers(String postID);
    List<Comment> fetchComments(String parentID);
}
