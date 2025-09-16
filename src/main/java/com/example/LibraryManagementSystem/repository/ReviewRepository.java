package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review , Long> {
}
