package com.example.stack_overflow.service;

import com.example.stack_overflow.dto.UserRecommendedQuestionDto;

public interface HomepageService {
    UserRecommendedQuestionDto getRecommendedQuestions(String userId, int pageNumber, int pageSize);
}
