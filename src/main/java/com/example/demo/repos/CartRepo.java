package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.models.Cart;

public interface CartRepo extends JpaRepository<Cart,Integer>
{

	List<Cart> findAllBycustomerId(int customerId);

	List<Cart> findAllByCustomerId(int customerId);

}
