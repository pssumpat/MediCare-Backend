package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Product;

public interface ProductService {
	
	public List<Product> getAllProduct();
	public Product getProductById(int id);
	public Product addProduct(Product p);
	public boolean removeProductById(int id);
	public Product updateProduct(int id,Product p); 

}
