package com.example.stack_overflow.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "answer")
@Data
@AllArgsConstructor
public class Answer extends BaseCollection{


    private String content;
    private User author;
    @Field("parent_id")
    private String parentId;
    @Field("answer_id")
    private Long answerId;
    private ArrayList<Answer> answers;
    private Long vote;

}
