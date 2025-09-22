package com.example.LibraryManagementSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ReviewResponseDto {



    @CreationTimestamp
    private LocalDateTime createdAt ;
}
