package com.example.LibraryManagementSystem.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BooksAvailableResponseDto {
    List<ShowBooksDto> books ;
}
