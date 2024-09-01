package com.example.stack_overflow.controller;

import com.example.stack_overflow.collection.Answer;
import com.example.stack_overflow.collection.User;
import com.example.stack_overflow.dto.QuestionWithAnswerDto;
import com.example.stack_overflow.dto.UserPageDto;
import com.example.stack_overflow.service.QuestionService;
import com.example.stack_overflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserDetails(
            @PathVariable("id") String userId) {

        UserPageDto user = userService.getUserPageDetails(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
