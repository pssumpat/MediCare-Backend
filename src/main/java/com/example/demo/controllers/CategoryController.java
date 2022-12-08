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

import com.example.demo.models.Category;
import com.example.demo.services.CategoryService;

@CrossOrigin(origins ={"http://localhost:4200","http://localhost:49335"})
@RestController
@RequestMapping("/api/category")
public class CategoryController 
{
	@Autowired
	CategoryService service;
	
	@GetMapping("")
	public ResponseEntity<Object> getCategory()
	{
		List<Category> resp = service.getAllCategory();
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@GetMapping("/{categoryId}")
	public ResponseEntity<Object> getCategoryById(@PathVariable("categoryId") int id)
	{
		Category resp = service.getCategoryById(id);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveCategory(@RequestBody Category c)
	{
		Category resp = service.addCategory(c);
		if(resp!=null)
		{
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error creating object",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<Object> updateCategory(@RequestBody Category c, @PathVariable("categoryId") int id)
	{
		Category resp = service.updateCategory(c,id);
		if(resp!=null)
		{
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error creating object",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<Object> deleteCategory(@PathVariable("categoryId") int id)
	{
		boolean resp = service.removeCategory(id);
		if(resp)
		{
			return new ResponseEntity<>(resp,HttpStatus.CREATED);
		}
		return new ResponseEntity<>("Error deleting object",HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
