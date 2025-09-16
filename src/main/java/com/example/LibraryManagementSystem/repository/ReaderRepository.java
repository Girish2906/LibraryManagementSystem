package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.entity.Reader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReaderRepository extends JpaRepository<Reader, Long> {
}
