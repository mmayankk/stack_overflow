package com.example.stack_overflow.repository;

import com.example.stack_overflow.collection.Answer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomAnswerRepository {
    Page<Answer> findByParentId(String parentId, Pageable pageable, String sortBy);
}
