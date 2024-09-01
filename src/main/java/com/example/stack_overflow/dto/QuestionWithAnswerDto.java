package com.example.stack_overflow.dto;

import com.example.stack_overflow.collection.Answer;
import lombok.Data;

import java.util.List;
@Data
public class QuestionWithAnswerDto {
    String question;
    List<Answer> answers;
    Long totalAnswers;
}
