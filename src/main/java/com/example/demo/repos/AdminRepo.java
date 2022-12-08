package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Admin;

public interface AdminRepo extends JpaRepository<Admin,Integer> {

	Admin findByEmail(String email);

}
