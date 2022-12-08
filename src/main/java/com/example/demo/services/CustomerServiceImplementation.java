package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Customer;
import com.example.demo.repos.CustomerRepo;

@Service
public class CustomerServiceImplementation implements CustomerService{

	@Autowired
	CustomerRepo repo;
	@Override
	public Customer addCustomer(Customer c) {
		repo.save(c);
		return c;
	}

	@Override
	public boolean removeCustomerById(int id) 
	{
		if(repo.findById(id).isPresent())
		{
			repo.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public Customer getCustomerById(int id) 
	{
		if(repo.findById(id).isPresent())
		{
			return repo.findById(id).get();
		}
		return null;
	}

	@Override
	public List<Customer> getAllCustomer() 
	{	
		return repo.findAll();
	}

	@Override
	public Customer updateCustomer(Customer newC, int id) {
		Customer oldC = repo.findById(id).get();
		oldC.setName(newC.getName());
		oldC.setEmail(newC.getEmail());
		oldC.setPhone(newC.getPhone());
		oldC.setAddress(newC.getAddress());
		oldC.setPassword(newC.getPassword());
		repo.save(oldC);
		return oldC;
	}

	@Override
	public Customer getCustomerByEmail(String email) 
	{
		return repo.findByEmail(email);
	}

}
