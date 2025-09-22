package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dtos.ReaderRequestDto;
import com.example.LibraryManagementSystem.dtos.ReaderResponseDto;

public interface ReaderService {
    ReaderResponseDto saveNewReader(ReaderRequestDto readerRequestDto) ;
}
