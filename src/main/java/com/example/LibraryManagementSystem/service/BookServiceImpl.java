package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dtos.*;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LibraryManagementSystem.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static java.util.stream.Collectors.toList;

@Service
public class BookServiceImpl implements  BookService{
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository , ModelMapper modelMapper) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.modelMapper = modelMapper ;
    }
    private final AuthorRepository authorRepository ;
    private final BookRepository bookRepository ;
    private final ModelMapper modelMapper ;
    @Transactional
    public BookResponseDto createBook(BookRequestDto bookRequestDto , Long authorId){
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new RuntimeException("Author with id: " + authorId + " doesn't exist" )) ;
        Book newBook = modelMapper.map(bookRequestDto , Book.class) ;
        newBook.setAuthor(author);

        Book bookSaved = bookRepository.save(newBook) ;
        log.info("Book saved: {}", bookSaved);
        BookResponseDto answer = modelMapper.map(bookSaved , BookResponseDto.class) ;
        AuthorResponseDto authorResponseDto = modelMapper.map(author , AuthorResponseDto.class) ;
        authorResponseDto.setProfileResponseDto(modelMapper.map(author.getProfile() , ProfileResponseDto.class));
        authorResponseDto.getProfileResponseDto().setProfilePic(author.getProfile().getProfilePic());
//        authorResponseDto.setProfilePic(author.getProfile().getProfilePic());
        answer.setAuthorResponseDto(authorResponseDto);
        return answer ;
    }

    public List<BookResponseDto> findBookById(Long authorId){
        List<Book> listOfBooks = bookRepository.findByAuthorId(authorId) ;
        List<BookResponseDto> listDTO = listOfBooks.stream()
                .map(book -> new BookResponseDto(
                         modelMapper.map(book.getAuthor() , AuthorResponseDto.class) ,
                        book.getName() , book.getPages() , book.getAvailableCopies()
                )).toList() ;
        return listDTO ;
    }

    @Override
    public List<ShowBooksDto> findAllBooks(){
        List<Book> bookList = bookRepository.findByAvailableCopiesGreaterThan(1) ;
        List<ShowBooksDto> showBooksDtos = bookList.stream()
                .map(book -> {
                    ShowBooksDto showBooksDto = modelMapper.map(book , ShowBooksDto.class) ;
                    showBooksDto.setAuthorName(book.getAuthor().getName());
                    return showBooksDto ;
                }).toList() ;
        return showBooksDtos ;

    }

//    @Override
//    public BooksAvailableResponseDto findAllBooks() {
//       List<Book> bookList = bookRepository.findByAvailableCopiesGreaterThan(1) ;
//       log.info("Books found: {}"  + bookList);
//       List<BookResponseDto> bookResponseDtos = bookList.stream()
//               .map(book -> {
//                   AuthorResponseDto authorDto = modelMapper.map(book.getAuthor() , AuthorResponseDto.class) ;
//                   AuthorResponseDto authorDto = null ;
//                   return new BookResponseDto(authorDto, book.getName() , book.getPages() , book.getAvailableCopies() );
//               }).toList() ;
//       BooksAvailableResponseDto booksAvailableResponseDto = new BooksAvailableResponseDto() ;
//       booksAvailableResponseDto.setBooks(bookResponseDtos);
//       return booksAvailableResponseDto ;
//
//
//    }
}
