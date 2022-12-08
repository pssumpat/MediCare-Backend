package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.repos.CategoryRepo;

@Service
public class CategoryServiceImpl implements CategoryService 
{

	
	@Autowired
	CategoryRepo repo;
	
	@Override
	public Category addCategory(Category cgry) 
	{
		if(repo.findById(cgry.getId()).isPresent())
		{
			return null;
		}
		repo.save(cgry);
		return cgry;
	}

	@Override
	public boolean removeCategory(int id) 
	{
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Category> getAllCategory() 
	{
		return repo.findAll();
	}

	@Override
	public Category getCategoryById(int id) 
	{
		if(repo.findById(id).isPresent())
		{
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public Category updateCategory(Category newC,int id) 
	{
		Category oldC = repo.findById(id).get();
		oldC.setName(newC.getName());
		repo.save(oldC);
		return oldC;
	}

}
