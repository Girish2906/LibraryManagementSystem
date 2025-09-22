package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dtos.AuthorRequestDto;
import com.example.LibraryManagementSystem.dtos.AuthorResponseDto;

public interface AuthorService {

    public AuthorResponseDto createAuthor(AuthorRequestDto authorRequestDto) ;

    public AuthorResponseDto findAuthorProfileWithBooksWritten(Long authorId) ;

    void generateQueryN1();
}
