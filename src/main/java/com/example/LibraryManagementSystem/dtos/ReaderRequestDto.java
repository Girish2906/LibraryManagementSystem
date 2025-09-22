package com.example.LibraryManagementSystem.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReaderRequestDto {
    private String name ;
    private String phoneNumber ;
    private String city ;
    private Integer pinCode ;
    private String profilePic ;
}
