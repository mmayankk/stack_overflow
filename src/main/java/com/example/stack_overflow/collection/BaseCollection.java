package com.example.stack_overflow.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;
import java.util.Date;
@Data
public class BaseCollection {
    @Id
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
