package com.QuoraProject.QAMicroservice.controller;

import com.QuoraProject.QAMicroservice.entity.Comment;
import com.QuoraProject.QAMicroservice.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comment")
    public void addComment(@RequestBody Comment comment)
    {
        commentService.addComment(comment);
    }

    @GetMapping("/comment/{parentID}")
    public List<Comment> fetchComments(@PathVariable("parentID") String parentID)
    {
        return commentService.fetchComments(parentID);
    }

}
