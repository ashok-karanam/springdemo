package com.webapp3.service;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.webapp3.model.Customer;

@Component
public class CustomerService {
	private int customerIdCount = 1;
	private List<Customer> customerList = new ArrayList<Customer>();
	
	public Customer addCustomer(Customer customer) {
		customer.setCustomerId(customerIdCount);
		customerList.add(customer);
		customerIdCount++;
		return customer;
	}
	
	public List<Customer> getCustomers() {
		return customerList;
	}
	
	public Customer getCustomer(int customerId) {
		return customerList
				.stream()
				.filter(c -> c.getCustomerId() == customerId)
				.findFirst()
				.get();
	}
	
	public Customer updateCustomer(int customerId, Customer customer) {
		customerList.stream()
		.forEach(c -> {
			if(c.getCustomerId() == customerId) {
				c.setCustomerFirstName(customer.getCustomerFirstName());
				c.setCustomerLastName(customer.getCustomerLastName());
				c.setCustomerEmail(customer.getCustomerEmail());
			}
		});
		
		return customerList.stream()
				.filter(c -> c.getCustomerId() == customerId)
				.findFirst()
				.get();
	}
	
	public void deleteCustomer(int customerId) {
		customerList.stream()
		.forEach(c -> {
		    if(c.getCustomerId() == customerId) {
		    	customerList.remove(c);
		    }	
		});
	}
	
	
}
