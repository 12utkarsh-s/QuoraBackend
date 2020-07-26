package com.QuoraProject.QAMicroservice.service.impl;

import com.QuoraProject.QAMicroservice.entity.Link;
import com.QuoraProject.QAMicroservice.entity.Post;
import com.QuoraProject.QAMicroservice.repository.QuestionRepository;
import com.QuoraProject.QAMicroservice.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    QuestionRepository questionRepository;

    private RestTemplateBuilder restTemplateBuilder=new RestTemplateBuilder();

    private final RestTemplate restTemplate=restTemplateBuilder.build();


    @Override
    public void addPost(Post post) {
         questionRepository.save(post);
         createPost(post.getUserID());
    }


    public Link createPost(String userId) {
        String url="http://localhost:8081/Analytic/points";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        Link link= new Link(userId,10);
        HttpEntity<Link> entity = new HttpEntity<>(link, headers);
        return restTemplate.postForObject(url, entity, Link.class);
    }

}
