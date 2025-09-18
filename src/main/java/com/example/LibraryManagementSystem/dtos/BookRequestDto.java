package com.example.LibraryManagementSystem.dtos;

import lombok.Data;

@Data
public class BookRequestDto {
    private String name ;
    private Integer pages ;
    private Integer availableCopies ;
}
