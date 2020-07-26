package com.QuoraProject.QAMicroservice.repository.impl;

import com.QuoraProject.QAMicroservice.entity.Answer;
import com.QuoraProject.QAMicroservice.entity.Comment;
import com.QuoraProject.QAMicroservice.repository.CustomQueryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.solr.core.SolrTemplate;
import org.springframework.data.solr.core.query.Criteria;
import org.springframework.data.solr.core.query.SimpleQuery;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class CustomQueryRepoImpl implements CustomQueryRepository {

    @Resource
    private SolrTemplate solrTemplate;

    @Override
    public List<Answer> fetchAnswers(String searchTerm) {
        String[] words = searchTerm.split(" ");

        Criteria conditions = createSearchConditions1(words);
        SimpleQuery search = new SimpleQuery(conditions);

        Page results = solrTemplate.query("answer",search,Answer.class);
        return results.getContent();
    }

    private Criteria createSearchConditions1(String[] words) {
        Criteria conditions = null;

        for (String word: words) {
            if (conditions == null) {
                conditions = new Criteria("postID").contains(word);
            }
            else {
                conditions = conditions.or(new Criteria("postID").contains(word));
            }
        }

        return conditions;
    }

    @Override
    public List<Comment> fetchComments(String searchTerm) {
        String[] words = searchTerm.split(" ");

        Criteria conditions = createSearchConditions2(words);
        SimpleQuery search = new SimpleQuery(conditions);

        Page results = solrTemplate.query("comment",search,Comment.class);
        return results.getContent();
    }

    private Criteria createSearchConditions2(String[] words) {
        Criteria conditions = null;

        for (String word: words) {
            if (conditions == null) {
                conditions = new Criteria("parentID").contains(word);
            }
            else {
                conditions = conditions.or(new Criteria("parentID").contains(word));
            }
        }

        return conditions;
    }
}
