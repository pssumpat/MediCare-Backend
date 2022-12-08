package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.Cart;
import com.example.demo.services.CartService;

@CrossOrigin(origins ={"http://localhost:4200","http://localhost:49335"})
@RestController
@RequestMapping("/api/cart")
public class CartController 
{
	
	@Autowired
	CartService service;
	
	@GetMapping("/{customerId}")
	public ResponseEntity<Object> getCartItems(@PathVariable("customerId") int id)
	{
		List<Cart> resp = service.getAllCartItems(id);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveCartItem(@RequestBody Cart cartItem)
	{
		Cart resp = service.addToCart(cartItem);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{cartId}")
	public ResponseEntity<Object> deleteCartItem(@PathVariable("cartId") int id)
	{
		boolean resp = service.deleteFromCart(id);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}

}
