package com.example.LibraryManagementSystem.dtos;

import lombok.Data;

@Data
public class AuthorRequestDto {
    private String name ;
    private String phoneNumber ;
    private String city ;
    private Integer pinCode ;
    private String profilePic ;
}
