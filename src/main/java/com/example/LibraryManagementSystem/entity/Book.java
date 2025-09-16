package com.example.LibraryManagementSystem.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;
    private Integer pages ;
    private Integer availableCopies ;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author ;

    @OneToMany(mappedBy = "book")
    private List<Review> reviewList ;

    @ManyToMany(mappedBy = "borrowedBooks")
    private List<Reader> readers ;

}
