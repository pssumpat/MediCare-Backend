package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Cart;
import com.example.demo.repos.CartRepo;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepo repo;
	
	@Override
	public Cart addToCart(Cart cartItem) {
		repo.save(cartItem);
		return cartItem;
		
	}

	@Override
	public boolean deleteFromCart(int cartId) {
		repo.deleteById(cartId);
		return true;
	}

	@Override
	public List<Cart> getAllCartItems(int customerId) {
		return repo.findAllByCustomerId(customerId);
	}
//	@Override
//	public List<Cart> getAllCartItems(int customerId) {
//		return repo.findAllById(customerId);
//	}

}
