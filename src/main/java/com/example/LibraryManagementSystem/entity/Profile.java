package com.example.LibraryManagementSystem.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    private String name ;
    private String city ;
    private String profilePic ;
    private Integer pinCode ;
    private String phoneNumber ;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private Reader reader ;

    @OneToOne(mappedBy = "profile" , cascade = {CascadeType.PERSIST , CascadeType.MERGE})
    @ToString.Exclude
    private Author author ;
}