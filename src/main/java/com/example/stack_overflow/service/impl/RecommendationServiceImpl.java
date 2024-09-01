package com.example.stack_overflow.service.impl;

import com.example.stack_overflow.collection.UserRecommendedQuestion;
import com.example.stack_overflow.dto.UserRecommendedQuestionDto;
import com.example.stack_overflow.repository.UserRecommendedQuestionRepository;
import com.example.stack_overflow.service.RecommendationService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@Slf4j
public class RecommendationServiceImpl implements RecommendationService {
    static final Logger logger = LoggerFactory.getLogger(RecommendationServiceImpl.class);
    UserRecommendedQuestionRepository userRecommendedQuestionRepository;
    @Override
    public UserRecommendedQuestionDto getRecommendedQuestions(String userId, int pageNumber, int pageSize) {
        try {
            Pageable pageable = PageRequest.of(pageNumber, pageSize);
            Page<UserRecommendedQuestion> userRecommendedQuestionPage = userRecommendedQuestionRepository.findByUserIdOrderByScoreDesc(userId, pageable);
            UserRecommendedQuestionDto recommendedQuestionDto = new UserRecommendedQuestionDto();
            recommendedQuestionDto.setQuestions(userRecommendedQuestionPage.getContent());
            recommendedQuestionDto.setTotalQuestions(userRecommendedQuestionPage.getTotalElements());
            return recommendedQuestionDto;
        }
        catch (Exception e) {
            log.error("Something went wrong {}",e);
            return null;

        }
    }

}
