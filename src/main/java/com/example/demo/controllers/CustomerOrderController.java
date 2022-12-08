package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.CustomerOrder;
import com.example.demo.services.CustomerOrderService;

@CrossOrigin(origins ={"http://localhost:4200","http://localhost:49335"})
@RestController
@RequestMapping("/api/order")
public class CustomerOrderController 
{
	@Autowired
	CustomerOrderService service;
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Object> getOrderById(@PathVariable("orderId") int id)
	{
		CustomerOrder resp = service.getOrderById(id);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@GetMapping("")
	public ResponseEntity<Object> getAllOrder()
	{
		List<CustomerOrder> resp = service.getAllOrders();		
		return  new ResponseEntity<>(resp,HttpStatus.CREATED);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> saveOrder(@RequestBody CustomerOrder o)
	{
		CustomerOrder resp = service.saveOrder(o);
		return new ResponseEntity<>(resp,HttpStatus.CREATED);
	}

}
