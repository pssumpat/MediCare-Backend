package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.CustomerOrder;

public interface CustomerOrderRepo extends JpaRepository<CustomerOrder,Integer> {

}
