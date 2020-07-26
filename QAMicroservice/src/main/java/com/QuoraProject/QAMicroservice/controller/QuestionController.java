package com.QuoraProject.QAMicroservice.controller;

import com.QuoraProject.QAMicroservice.entity.Post;
import com.QuoraProject.QAMicroservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    QuestionService questionService;


    @PostMapping("/post")
    public void addPost(@RequestBody Post post)
    {
        questionService.addPost(post);
    }



}
