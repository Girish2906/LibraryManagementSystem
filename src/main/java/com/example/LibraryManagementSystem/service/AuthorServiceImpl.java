package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dtos.AuthorRequestDto;
import com.example.LibraryManagementSystem.dtos.AuthorResponseDto;
import com.example.LibraryManagementSystem.dtos.BookResponseDto;
import com.example.LibraryManagementSystem.dtos.ProfileResponseDto;
import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Book;
import com.example.LibraryManagementSystem.entity.Profile;
import com.example.LibraryManagementSystem.repository.AuthorRepository;
import com.example.LibraryManagementSystem.repository.BookRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private ModelMapper modelMapper ;
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository,
                             BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }
    @Transactional
    public AuthorResponseDto createAuthor(AuthorRequestDto authorRequestDto){
        Author author = modelMapper.map(authorRequestDto , Author.class) ;
        Profile profile = modelMapper.map(authorRequestDto , Profile.class) ;
        author.setProfile(profile);
        profile.setAuthor(author) ;
        Author authorSaved = authorRepository.save(author) ;
        String profilePic = authorSaved.getProfile().getProfilePic() ;
        System.out.println(41 + " " + profilePic + " " + authorSaved);
        AuthorResponseDto authorResponseDto = new AuthorResponseDto() ;
        authorResponseDto.setProfileResponseDto(modelMapper.map(profile , ProfileResponseDto.class));
//        AuthorResponseDto authorResponseDto = modelMapper.map(authorSaved , AuthorResponseDto.class) ;
//        authorResponseDto.setProfilePic(profilePic);
//        authorResponseDto.getProfileResponseDto().setProfilePic(profilePic) ;
        return authorResponseDto ;
    }

    public AuthorResponseDto findAuthorProfileWithBooksWritten(Long authorId){
        Author author = authorRepository.findById(authorId).orElseThrow(() -> new ResourceAccessException("Cannot find author with id: " + authorId)) ;
        AuthorResponseDto authorResponseDto = new AuthorResponseDto() ;
        Profile profile = author.getProfile() ;
        authorResponseDto.setProfileResponseDto(modelMapper.map(profile , ProfileResponseDto.class));
        List<Book> booksByAuthor = bookRepository.findByAuthorId(authorId) ;
        List<BookResponseDto> bookResponseDtos = booksByAuthor.stream()
                .map(book -> modelMapper.map(book , BookResponseDto.class)).toList() ;
        authorResponseDto.setBooks(bookResponseDtos);
        return authorResponseDto ;
    }

    public void generateQueryN1(){
        int count =0 ;
        List<Author> authors = authorRepository.findAll();
        ++count ;
        for (Author author : authors) {
            ++count ;
            System.out.println(author.getBooks().size()); // triggers 1 query per author
        }
        System.out.println("This much queries were made: " + count);
    }
}
