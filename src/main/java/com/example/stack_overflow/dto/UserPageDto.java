package com.example.stack_overflow.dto;

import com.example.stack_overflow.collection.Question;
import lombok.Data;

import java.util.List;
@Data
public class UserPageDto {
    String username;
    String badge;
    List<Question> userQuestions;

}
