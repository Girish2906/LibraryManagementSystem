package com.example.LibraryManagementSystem.dtos;

import com.example.LibraryManagementSystem.entity.Author;
import lombok.Data;

@Data
public class BookResponseDto {
    private String name ;
    private Integer pages ;
    private Integer availableCopies ;
    private AuthorResponseDto author ;
}
