package com.example.LibraryManagementSystem;

import com.example.LibraryManagementSystem.entity.Author;
import com.example.LibraryManagementSystem.entity.Profile;
import com.example.LibraryManagementSystem.entity.Review;
import com.example.LibraryManagementSystem.repository.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.ResourceAccessException;

// we use configuration on the class, where we have defined methods whose return type we want to be treated as beans. because we don't own these beans, so we can't annotate them with component annotation
// component is a class level annotation, it tells spring to instantiate it and manage it.
@Configuration


public class DataInitializer {
    private final AuthorRepository authorRepository ;

    private final BookRepository bookRepository ;

    private final ProfileRepository profileRepository ;

    private final ReaderRepository readerRepository ;

    private final ReviewRepository reviewRepository ;

    public DataInitializer(AuthorRepository authorRepository, BookRepository bookRepository, ProfileRepository profileRepository, ReaderRepository readerRepository, ReviewRepository reviewRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.profileRepository = profileRepository;
        this.readerRepository = readerRepository;
        this.reviewRepository = reviewRepository;
    }

    // I can't put COMPONENT annotation on classes I don't own, for eg this commandLineRunner, or jackson library
    // here in this method, spring makes a bean of the commandLineRunner object,
    // with the bean annotation over the fun def, spring register the object returned from the function as a bean
    @Bean
    public CommandLineRunner initializeData() {
        return (args) -> {
            // making the authors
            {
//                Author author1 = new Author();
//                author1.setName("Stephen King");
//                author1.setPhoneNumber("89738794619");
//                author1.setCity("San Francisco");
//                author1.setPinCode(1222001);
//                Profile profile1 = new Profile() ;
//                profile1.setProfilePic("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSYhjECnH-RS5-N5ElpgZQ5mD7dJdYGbjIH1Q&s");
//                author1.setProfile(profile1);
//                Author a1 = authorRepository.save(author1);
//                Author author2 = new Author();
//                author2.setName("Agatha Christie");
//                author2.setPhoneNumber("9823749823");
//                author2.setCity("London");
//                author2.setPinCode(445566);
//                Author a2 = authorRepository.save(author2);
//
//                Author author3 = new Author();
//                author3.setName("J.K. Rowling");
//                author3.setPhoneNumber("9182736450");
//                author3.setCity("Edinburgh");
//                author3.setPinCode(110078);
//                Author a3 = authorRepository.save(author3);
//
//                Author author4 = new Author();
//                author4.setName("George R. R. Martin");
//                author4.setPhoneNumber("9988776655");
//                author4.setCity("Bayonne");
//                author4.setPinCode(90801);
//                Author a4 = authorRepository.save(author4);
//
//                Profile profile2 = new Profile() ;
//                profile2.setName("stephenie meyer 18");
//                profile2.setCity("Forks");
//                profile2.setProfilePic("https://google.com");
//                profile2.setPinCode(124311);
//                profile2.setPhoneNumber("2126413235");
//                Author author5 = new Author();
//                author5.setName("Haruki Murakami");
//                author5.setPhoneNumber("9123456789");
//                author5.setCity("Tokyo");
//                author5.setPinCode(150001);
//                Author a5 = authorRepository.save(author5);
//                profile2.setAuthor(author5);
                // this line pushes the foreign key value to the DB
                // author is the owning side, thus it can only save the foreign key in the DB
//                author5.setProfile(profile2);
//                Profile p3 = profileRepository.save(profile2) ;

//                Profile profile3 = new Profile();
//                profile3.setName("Dan Brown 18");
//                profile3.setCity("New Hampshire");
//                profile3.setProfilePic("https://example.com/danbrown.jpg");
//                profile3.setPinCode(458920);
//                profile3.setPhoneNumber("9876543210");
//                Author author6 = new Author();
//                author6.setName("Neil Gaiman 18");
//                author6.setPhoneNumber("9012345678");
//                author6.setCity("Portchester");
//                author6.setPinCode(342112);
//                profile3.setAuthor(author6);
//                author6.setProfile(profile2);
//                Profile p4 = profileRepository.save(profile3);
//                Author a6 = authorRepository.save(author6);

//                Profile p9 = profileRepository.findById(7L).orElseThrow(() -> new RuntimeException("Resource Not Found")) ;
//                System.out.println(p9);
//                Author a10 = p9.getAuthor() ;
//                System.out.println("113 author printed: "  + a10);
                Author author = authorRepository.findById(1L).orElseThrow(() -> new ResourceAccessException("Author not found with id: 1")) ;
                System.out.println(116 + " " + author );

                authorRepository.deleteById(3L);
            }
        } ;
    }

}