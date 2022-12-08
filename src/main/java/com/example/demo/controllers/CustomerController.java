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

import com.example.demo.models.Customer;
import com.example.demo.services.CustomerService;

@CrossOrigin(origins ={"http://localhost:4200","http://localhost:49335"})
@RestController
@RequestMapping("api/customer")
public class CustomerController {

	@Autowired
	CustomerService service;
	
	@GetMapping("")
	public ResponseEntity<Object> getCustomers()
	{
		List<Customer> resp = service.getAllCustomer();
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
//	@GetMapping("{customerId}")
//	public ResponseEntity<Object> getCustomerById(@PathVariable("customerId") int id)
//	{
//		Customer resp = service.getCustomerById(id);
//		return new ResponseEntity<>(resp,HttpStatus.CREATED);
//	}
	
	@GetMapping("{customerEmail}")
	public ResponseEntity<Object> getCustomerByEmail(@PathVariable("customerEmail") String email)
	{
		Customer resp = service.getCustomerByEmail(email);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("")
	public ResponseEntity<Object> addUser(@RequestBody Customer c)
	{
		Customer resp = service.addCustomer(c);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("{customerId}")
	public ResponseEntity<Object> deleteUserById(@PathVariable("customerId") int id)
	{
		boolean resp = service.removeCustomerById(id);
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	@PutMapping("{customerId}")
	public ResponseEntity<Object> saveOrUpdateUser(@RequestBody Customer newC, @PathVariable("customerId") int id)
	{
		Customer resp = service.updateCustomer(newC, id);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
}
