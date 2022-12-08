package com.example.demo.services;

import java.util.List;

import com.example.demo.models.CustomerOrder;

public interface CustomerOrderService 
{
	public CustomerOrder saveOrder(CustomerOrder o);
	public CustomerOrder getOrderById(int id);
	public List<CustomerOrder> getAllOrders();

}
