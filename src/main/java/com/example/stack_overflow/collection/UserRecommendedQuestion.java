package com.example.stack_overflow.collection;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user_recommended_question")
public class UserRecommendedQuestion {
    private String userId;
    private Question question;

    private Long score;
}

/*
we can get user last answered questions comments questions upvotes and find the most similar question from
elastic search
answered questions user tags etc and can find the relative scoring
so we can get that score + trending score + ... and make a cumulative score based on their weightage for each question and update the score
 */