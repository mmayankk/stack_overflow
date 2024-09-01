package com.example.stack_overflow.controller;

import com.example.stack_overflow.dto.QuestionByTagListDto;
import com.example.stack_overflow.dto.QuestionWithAnswerDto;
import com.example.stack_overflow.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/answers/{id}")
    public ResponseEntity<?> getQuestionWithAnswer(
            @PathVariable("id") String questionId,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize,
            @RequestParam(defaultValue = "vote") String sortBy) {

        QuestionWithAnswerDto question = questionService.getQuestionWithAnswerDto(questionId, pageNumber, pageSize, sortBy);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
    @GetMapping("/tag")
    public ResponseEntity<?> getQuestionForTag(
            @RequestParam(defaultValue = "") String tag,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {

        QuestionByTagListDto question = questionService.getQuestionForTag(tag,pageNumber, pageSize);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }


}
