package com.example.demo.services;

import java.util.List;

import com.example.demo.models.Customer;

public interface CustomerService 
{
	public Customer addCustomer(Customer c);
	public boolean removeCustomerById(int id);
	public Customer getCustomerById(int id);
	public List<Customer> getAllCustomer();
	public Customer updateCustomer(Customer newC, int id);
	public Customer getCustomerByEmail(String email);

}
