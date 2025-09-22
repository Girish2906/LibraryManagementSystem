package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dtos.BookRequestDto;
import com.example.LibraryManagementSystem.dtos.BookResponseDto;
import com.example.LibraryManagementSystem.dtos.BooksAvailableResponseDto;
import com.example.LibraryManagementSystem.dtos.ShowBooksDto;

import java.util.List;

public interface BookService {
    BookResponseDto  createBook(BookRequestDto book , Long authorId) ;

    List<BookResponseDto> findBookById(Long id) ;

    List<ShowBooksDto> findAllBooks();
}
