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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Product;
import com.example.demo.services.ProductService;


@CrossOrigin(origins ={"http://localhost:4200","http://localhost:49335"})
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	ProductService service;
	
	@GetMapping("")
	public List<Product> getProducts()
	{
		return service.getAllProduct();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Object> getProductById(@PathVariable("id") int id)
	{
		Product resp = service.getProductById(id);
		if(resp!=null)
		{
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error while creating object", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addProduct(@RequestBody Product product)
	{
		Product resp = service.addProduct(product);
		if(resp!=null)
		{
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error while creating object", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<Object> deleteProductById(@PathVariable("productId") int productId)
	{
		boolean resp = service.removeProductById(productId);
		if(resp)
		{
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error while creating object", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("{productId}")
	public ResponseEntity<Object> saveOrUpdateProductById(@RequestBody Product product,@PathVariable("productId") int productId)
	{
		Product resp = service.updateProduct(productId, product);
		if(resp!=null)
		{
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error while creating object", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
