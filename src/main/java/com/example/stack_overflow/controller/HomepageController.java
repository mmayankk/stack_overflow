package com.example.stack_overflow.controller;

import com.example.stack_overflow.dto.UserRecommendedQuestionDto;
import com.example.stack_overflow.service.HomepageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/homepage")
public class HomepageController {

    @Autowired
    private HomepageService homepageService;
// Oauth authentication
    @GetMapping("get-recommended-questions")
    public ResponseEntity<?> getRecommendedQuestions(
            @PathVariable("user_id") String userId,
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize
    ) {

        UserRecommendedQuestionDto recommendedQuestionDto = homepageService.getRecommendedQuestions(userId, pageNumber, pageSize);
        return new ResponseEntity<>(recommendedQuestionDto, HttpStatus.OK);
    }


}
