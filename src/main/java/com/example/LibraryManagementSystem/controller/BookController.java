package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dtos.BookRequestDto;
import com.example.LibraryManagementSystem.dtos.BookResponseDto;
import com.example.LibraryManagementSystem.service.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BookController {
    private final BookService bookService ;
    private final AuthorService authorService ;
    private final ProfileService profileService ;
    private final ReaderService readerService ;
    private final ReviewService reviewService ;

    public BookController(BookService bookService, AuthorService authorService, ProfileService profileService, ReaderService readerService, ReviewService reviewService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.profileService = profileService;
        this.readerService = readerService;
        this.reviewService = reviewService;
    }

    @PostMapping("/authors/{authorId}/book")
    public ResponseEntity<BookResponseDto> newBook(@RequestBody BookRequestDto bookDto , @PathVariable Long authorId){
        System.out.println("Request sent");
        BookResponseDto bookResponseDto = bookService.createBook(bookDto , authorId) ;
        return new ResponseEntity<>(bookResponseDto , HttpStatus.CREATED) ;
    }
}