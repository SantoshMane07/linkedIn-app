package com.codingshuttle.linkedin.posts_service.dto;

import jakarta.persistence.Column;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class PostDto {
    private Long id;
    private String content;
    private Long userId;
    private LocalDateTime createdAt;
}
