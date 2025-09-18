package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dtos.BookRequestDto;
import com.example.LibraryManagementSystem.dtos.BookResponseDto;

public interface BookService {
    BookResponseDto  createBook(BookRequestDto book , Long authorId) ;
}
