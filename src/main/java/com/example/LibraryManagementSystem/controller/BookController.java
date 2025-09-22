package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dtos.AuthorRequestDto;
import com.example.LibraryManagementSystem.dtos.AuthorResponseDto;
import com.example.LibraryManagementSystem.dtos.BookRequestDto;
import com.example.LibraryManagementSystem.dtos.BookResponseDto;
import com.example.LibraryManagementSystem.service.*;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping("/author")
    public ResponseEntity<AuthorResponseDto> newAuthor(  @RequestBody AuthorRequestDto authorRequestDto){
        AuthorResponseDto authorResponseDto = authorService.createAuthor(authorRequestDto) ;
        return new ResponseEntity<>(authorResponseDto , HttpStatus.CREATED) ;
    }

    @PostMapping("/authors/{authorId}/book")
    public ResponseEntity<BookResponseDto> newBook(  @RequestBody BookRequestDto bookDto , @PathVariable Long authorId){
        System.out.println("Request sent");
        BookResponseDto bookResponseDto = bookService.createBook(bookDto , authorId) ;
        return new ResponseEntity<>(bookResponseDto , HttpStatus.CREATED) ;
    }

    @GetMapping("/authors/{authorId}/book")
    public ResponseEntity<List<BookResponseDto>> findBook(@PathVariable Long authorId){
        List<BookResponseDto> listOfBooks = bookService.findBookById(authorId) ;
        return new ResponseEntity<>(listOfBooks , HttpStatus.FOUND) ;
    }
    @GetMapping("/authors/{authorId}/profile/book")
    public ResponseEntity<AuthorResponseDto> findAuthorProfileWithBooks(@PathVariable Long authorId){
        AuthorResponseDto authorProfileWithBooks = authorService.findAuthorProfileWithBooksWritten(authorId) ;
        return new ResponseEntity<>(authorProfileWithBooks , HttpStatus.FOUND) ;
    }

    @GetMapping("/authors/n1/query")
    public void n1queryProblem(){
        authorService.generateQueryN1() ;
    }


}