package com.example.LibraryManagementSystem.service;

import com.example.LibraryManagementSystem.dtos.ReadResponseDto;
import com.example.LibraryManagementSystem.dtos.ReaderRequestDto;
import com.example.LibraryManagementSystem.dtos.ReaderResponseDto;
import com.example.LibraryManagementSystem.entity.Profile;
import com.example.LibraryManagementSystem.entity.Reader;
import com.example.LibraryManagementSystem.repository.ReaderRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class ReaderServiceImpl implements ReaderService {
    private static final Logger log = LoggerFactory.getLogger(BookServiceImpl.class);
    @Autowired
    private ModelMapper modelMapper ;
    private final ReaderRepository readerRepository;

    public ReaderServiceImpl(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }

    public ReaderResponseDto saveNewReader(ReaderRequestDto readerRequestDto){
        log.info("saving this dto: {}" , readerRequestDto);
        Profile profile = modelMapper.map(readerRequestDto , Profile.class) ;
        Reader reader = new Reader() ;
        reader.setProfile(profile);
        profile.setReader(reader);
        Reader savedReader = readerRepository.save(reader) ;
        ReaderResponseDto readerResponseDto = modelMapper.map(savedReader , ReaderResponseDto.class) ;
        return readerResponseDto ;
    }

    public ReadResponseDto readRequestForABook(Long readerId , Long bookId){
        return null ;
    }
}
