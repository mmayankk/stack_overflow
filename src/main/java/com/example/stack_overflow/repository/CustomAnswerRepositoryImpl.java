package com.example.stack_overflow.repository;

import com.example.stack_overflow.collection.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomAnswerRepositoryImpl implements CustomAnswerRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Page<Answer> findByParentId(String parentId, Pageable pageable, String sortBy) {
        Query query = new Query();
        query.addCriteria(Criteria.where("parentId").is(parentId));

        // Apply dynamic sorting
        if (sortBy != null && !sortBy.isEmpty()) {
            query.with(Sort.by(Sort.Order.by(sortBy)));
        }

        // Apply pagination
        long total = mongoTemplate.count(query, Answer.class);
        query.with(pageable);

        List<Answer> answers = mongoTemplate.find(query, Answer.class);
        return new PageImpl<>(answers, pageable, total);
    }
}
