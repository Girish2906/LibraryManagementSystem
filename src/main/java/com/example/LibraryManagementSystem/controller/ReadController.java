package com.example.LibraryManagementSystem.controller;

import com.example.LibraryManagementSystem.dtos.BooksAvailableResponseDto;
import com.example.LibraryManagementSystem.dtos.ReaderRequestDto;
import com.example.LibraryManagementSystem.dtos.ReaderResponseDto;
import com.example.LibraryManagementSystem.dtos.ShowBooksDto;
import com.example.LibraryManagementSystem.service.BookService;
import com.example.LibraryManagementSystem.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ReadController {
    @Autowired
    private ReaderService readerService ;
    @Autowired
    private BookService bookService ;

    @PostMapping("/reader")
    public ResponseEntity<ReaderResponseDto> createReader(@RequestBody ReaderRequestDto readerRequestDto){
        ReaderResponseDto readerResponseDto = readerService.saveNewReader(readerRequestDto) ;
        return new ResponseEntity<>(readerResponseDto , HttpStatus.CREATED) ;
    }

    @GetMapping("/book/read")
    public ResponseEntity<List<ShowBooksDto>> findBooks(){
        List<ShowBooksDto> listOfBooks = bookService.findAllBooks() ;
        return new ResponseEntity<>(listOfBooks , HttpStatus.FOUND) ;
    }

}
