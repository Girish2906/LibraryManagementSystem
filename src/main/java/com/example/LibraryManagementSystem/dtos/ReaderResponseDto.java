package com.example.LibraryManagementSystem.dtos;

import com.example.LibraryManagementSystem.entity.Profile;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReaderResponseDto {
    public Profile profile ;
    public List<BookResponseDto> borrowedBooks ;
    public List<ReviewResponseDto> reviews ;
}
