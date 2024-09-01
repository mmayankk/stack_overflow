package com.example.stack_overflow.service;

import com.example.stack_overflow.dto.QuestionByTagListDto;
import com.example.stack_overflow.dto.QuestionWithAnswerDto;
import org.springframework.stereotype.Service;


public interface QuestionService {
    public QuestionWithAnswerDto getQuestionWithAnswerDto(String questionId, int pageNumber, int pageSize, String orderby);
    public QuestionByTagListDto getQuestionForTag(String tag, int pageNumber, int pageSize);
}
