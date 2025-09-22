package com.example.LibraryManagementSystem.dtos;

import lombok.Data;

@Data
public class BookInfoDto {
    private Long id ;
    private String name ;
    private Integer pages ;
    private  Integer availableCopies ;
}
