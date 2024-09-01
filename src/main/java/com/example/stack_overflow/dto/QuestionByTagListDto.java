package com.example.stack_overflow.dto;

import com.example.stack_overflow.collection.Answer;
import com.example.stack_overflow.collection.QuestionByTag;
import lombok.Data;

import java.util.List;
@Data
public class QuestionByTagListDto {
    List<QuestionByTag> question;
    Long totalQuestions;
}
