package com.example.demoApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoApp.dto.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
