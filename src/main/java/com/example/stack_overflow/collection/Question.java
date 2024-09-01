package com.example.stack_overflow.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "question")
@Data
public class Question {

    @Id
    private String id;
    private Long questionId;
    private String content;// TODO: SET limit
    private User author;
    private ArrayList<Answer> answers;
    @Field("total_answers")
    private Long totalAnswers;
    private String preview;
    private Long vote;
}
