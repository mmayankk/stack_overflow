package com.example.stack_overflow.repository;

import com.example.stack_overflow.collection.Answer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepository extends MongoRepository<Answer, String>, CustomAnswerRepository {
}