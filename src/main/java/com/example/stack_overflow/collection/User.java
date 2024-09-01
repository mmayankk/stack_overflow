package com.example.stack_overflow.collection;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;

@Document(collection = "user")
@Data
public class User {

    @Id
    private String id;
    @Field("user_id")
    private Long userId;
    private String username;
    private String email;
    private LocalDateTime registrationDate;// maintained in UTC
    private String badge;
    @Field("no_of_posts")
    private Long noOfPosts;
    private Long reputation;
}