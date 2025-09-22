package com.example.LibraryManagementSystem.dtos;

import lombok.Data;

@Data
public class ShowBooksDto {
    private Long id ;
    private String name ;
    private Integer pages ;
    private Integer availableCopies ;
    private String authorName ;
}