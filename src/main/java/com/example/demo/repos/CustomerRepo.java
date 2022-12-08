package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Customer;

public interface CustomerRepo extends JpaRepository<Customer,Integer> {

	Customer findByEmail(String email);


}
