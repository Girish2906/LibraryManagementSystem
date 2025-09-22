package com.example.LibraryManagementSystem.dtos;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.List;

@Data
public class AvailableBooksDto {
    private List<BookInfoDto> listOfBooks ;
}