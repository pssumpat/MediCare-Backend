package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Product;
import com.example.demo.repos.ProductRepo;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepo repo;
	
	@Override
	public List<Product> getAllProduct() 
	{	
		return repo.findAll();
	}

	@Override
	public Product getProductById(int id) 
	{
		if(repo.findById(id).isPresent())
		{
			return repo.findById(id).get();
		}
		return null;
		
	}

	@Override
	public Product addProduct(Product p) 
	{
		repo.save(p);
		return p;
	}

	@Override
	public boolean removeProductById(int id) 
	{
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}	
		return false;
	}

	@Override
	public Product updateProduct(int id, Product p) 
	{
		if(repo.findById(id).isPresent())
		{
			Product oldP = repo.findById(id).get();
			oldP.setName(p.getName());
			oldP.setPrice(p.getPrice());
			oldP.setDescription(p.getDescription());
			oldP.setRating(p.getRating());
			repo.save(oldP);
			return oldP;
		}
		return null;
	}

}
