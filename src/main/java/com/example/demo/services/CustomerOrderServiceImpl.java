package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.CustomerOrder;
import com.example.demo.repos.CustomerOrderRepo;

@Service
public class CustomerOrderServiceImpl implements CustomerOrderService{

	@Autowired
	CustomerOrderRepo repo;
	@Override
	public CustomerOrder saveOrder(CustomerOrder o) {
		
		repo.save(o);
		return o;
	}

	@Override
	public CustomerOrder getOrderById(int id) 
	{
		if(repo.findById(id).isPresent())
		{
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public List<CustomerOrder> getAllOrders() 
	{
		return repo.findAll();
	}

}
