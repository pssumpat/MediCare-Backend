package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Category;

public interface CategoryService 
{
	public Category addCategory(Category cgry);
	public boolean removeCategory(int id);
	public List<Category> getAllCategory();
	public Category getCategoryById(int id);
	public Category updateCategory(Category newC,int id);
	
}
