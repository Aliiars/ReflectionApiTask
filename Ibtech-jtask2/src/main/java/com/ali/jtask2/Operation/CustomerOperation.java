package com.ali.jtask2.Operation;

import java.util.List;

import com.ali.jtask2.model.Customer;

public class CustomerOperation {
	
	public void add(List<Customer> customerList, Customer customer) {
		
		customerList.add(customer);
	}
	
	public void update(List<Customer> customerList, Customer customer, int index) {
		
		customerList.set(index, customer);
	}
	
	public void delete(List<Customer> customerList, int index) {
		
		customerList.remove(index);
	}

}
