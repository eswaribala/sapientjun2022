package com.boa.customer.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customer.models.Customer;
import com.boa.customer.services.CustomerService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

import io.opentracing.Span;
import io.opentracing.Tracer;
@Component
public class CustomerQueryResolver implements GraphQLQueryResolver{
	@Autowired
	private CustomerService customerService;
	@Autowired
	private Tracer tracer;
    public List<Customer> findAllCustomers(){
    	 Span span = tracer.buildSpan("accessing Filtered customers").start();
    	return this.customerService.getAllCustomers(span);
    }
	
	public Customer findCustomer(long customerId) {
		return this.customerService.getCustomerById(customerId);
	}
    
}
