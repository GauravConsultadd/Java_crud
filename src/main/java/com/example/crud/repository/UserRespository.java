package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.example.crud.model.User;

@Component
public interface UserRespository extends JpaRepository<User,Long> {
    
}
