package com.example.LibraryManagementSystem.repository;

import com.example.LibraryManagementSystem.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile , Long> {

}
