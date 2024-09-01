package com.example.stack_overflow.repository;

import com.example.stack_overflow.collection.QuestionByTag;
import com.example.stack_overflow.collection.UserRecommendedQuestion;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionByTagRepository extends MongoRepository<QuestionByTag,String> {
    Page<QuestionByTag> findByTagOrderByScoreDesc(String tag, Pageable pageable);
}
