package com.example.stack_overflow.repository;

import com.example.stack_overflow.collection.User;
import com.example.stack_overflow.collection.UserRecommendedQuestion;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
}