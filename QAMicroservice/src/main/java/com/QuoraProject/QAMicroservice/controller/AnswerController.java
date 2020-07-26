package com.QuoraProject.QAMicroservice.controller;

import com.QuoraProject.QAMicroservice.entity.Answer;
import com.QuoraProject.QAMicroservice.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/answer")
public class AnswerController {

    @Autowired
    AnswerService answerService;

    @PostMapping("/answer")
    public void addAnswer(@RequestBody Answer answer)
    {
        answerService.addAnswer(answer);
    }

    @GetMapping("/answer/{postID}")
    public List<Answer> fetchAnswers(@PathVariable("postID") String postID)
    {
        return answerService.fetchAnswers(postID);
    }

}
