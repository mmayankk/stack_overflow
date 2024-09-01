package com.example.stack_overflow.service.impl;

import com.example.stack_overflow.dto.UserRecommendedQuestionDto;
import com.example.stack_overflow.service.HomepageService;
import com.example.stack_overflow.service.RecommendationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class HomepageServiceImpl implements HomepageService {

    static final Logger logger = LoggerFactory.getLogger(HomepageServiceImpl.class);
    @Autowired
    public RecommendationService recommendationService;
    @Override
    public UserRecommendedQuestionDto getRecommendedQuestions(String userId, int pageNumber, int pageSize) {
        return recommendationService.getRecommendedQuestions(userId, pageNumber, pageSize);
    }
}
