package com.webapp3.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webapp3.model.Customer;
import com.webapp3.service.CustomerService;

@RestController
@RequestMapping(value="/customers")
public class CustomerResource {
    @Autowired
	private CustomerService customerservice;
	
    @PostMapping
	public Customer addCustomer(@RequestBody Customer customer) {
		return customerservice.addCustomer(customer);
	}
    
    @GetMapping
    @ResponseBody
    public List<Customer> getCustomers() {
    	return customerservice.getCustomers();
    }
    
    @GetMapping(value="/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") int customerId) {
    	return customerservice.getCustomer(customerId);
    }
	
    @PutMapping(value="/{customerId}")
    public Customer updateCustomer(@PathVariable("customerId") int customerId,@RequestBody Customer customer) {
    	return customerservice.updateCustomer(customerId,customer);
    }
    
    @DeleteMapping(value="/{customerId}")
    public void deleteCustomer(@PathVariable("customerId") int customerId) {
    	customerservice.deleteCustomer(customerId);
    }
}
