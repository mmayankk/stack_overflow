package com.example.stack_overflow.dto;

import com.example.stack_overflow.collection.Question;
import com.example.stack_overflow.collection.UserRecommendedQuestion;
import lombok.Data;

import java.util.List;

@Data
public class UserRecommendedQuestionDto {
    long totalQuestions;
    List<UserRecommendedQuestion> questions;
}
