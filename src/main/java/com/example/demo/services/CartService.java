package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Cart;

public interface CartService 
{
	public Cart addToCart(Cart cartItem);
	public boolean deleteFromCart(int cartId);
	public List<Cart> getAllCartItems(int customerId);

}
