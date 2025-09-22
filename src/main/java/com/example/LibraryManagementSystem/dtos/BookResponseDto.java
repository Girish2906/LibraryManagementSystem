package com.example.LibraryManagementSystem.dtos;

import com.example.LibraryManagementSystem.entity.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookResponseDto {
    private String name ;
    private Integer pages ;
    private Integer availableCopies ;
    private AuthorResponseDto authorResponseDto ;

    public BookResponseDto(AuthorResponseDto authorResponseDto , String name, Integer pages, Integer availableCopies) {
        this.authorResponseDto = authorResponseDto ;
        this.name = name;
        this.pages = pages;
        this.availableCopies = availableCopies;

    }
}
