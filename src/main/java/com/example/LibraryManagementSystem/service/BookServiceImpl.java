package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dtos.BookRequestDto;
import com.example.LibraryManagementSystem.dtos.BookResponseDto;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LibraryManagementSystem.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class BookServiceImpl implements  BookService{
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository , ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper ;
    }
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final ModelMapper modelMapper ;

    public BookResponseDto createBook(BookRequestDto bookRequestDto , Long authorId){
        System.out.println("coming here 25" + bookRequestDto);
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author with id: " + authorId + " doesn't exist" )) ;
        Book newBook = modelMapper.map(bookRequestDto , Book.class) ;
        newBook.setAuthor(author);
        System.out.println("29" + newBook);
        Book bookSaved = bookRepository.save(newBook) ;
        System.out.println("coming here 30");
        BookResponseDto answer = modelMapper.map(bookSaved , BookResponseDto.class) ;
        System.out.println(33 + " " + answer);
        return answer ;
    }
}
