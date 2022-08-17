package com.boa.customer.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boa.customer.models.Customer;
import com.boa.customer.models.FullName;
import com.boa.customer.services.CustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.bohnman.squiggly.Squiggly;
import com.github.bohnman.squiggly.util.SquigglyUtils;
import com.google.gson.Gson;

import io.opentracing.Span;
import io.opentracing.Tracer;

@RestController
@RequestMapping("/customers")
public class CustomerController {

	@Autowired
	private CustomerService customerService;	
	private Gson gson;	
    @Autowired
    private Tracer tracer;

	//adding customer
	@PostMapping({"/v1.0/"})
	public ResponseEntity<String> addv10Customer(@RequestBody Customer customer){
		gson=new Gson();
		
		if(this.customerService.addCustomer(customer)!=null)
			return ResponseEntity.status(HttpStatus.OK)
					.body(gson.toJson(customer));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Customer Not Added");
	}
	
	@PostMapping({"/v1.1/"})
	public ResponseEntity<String> addV11Customer(@RequestBody Customer customer){
		gson=new Gson();
		
		if(this.customerService.addV1Customer(customer)!=null)
			return ResponseEntity.status(HttpStatus.OK)
					.body(gson.toJson(customer));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Customer Not Added");
	}
	
	//getall
	@GetMapping({"/v1.0"})
	public List<Customer> getAllCustomers(){
        HttpStatus status=null;  

        Span span = tracer.buildSpan("accessing customers").start();
        List<Customer> customers=this.customerService.getAllCustomers(span);
        if (customers.size()>0) {
            status = HttpStatus.CREATED;
            span.setTag("http.status_code", 201);
        } else {
            span.setTag("http.status_code", 403);
        }
        span.finish();

        
		return customers;
	}
	
	//get customer by id
	@GetMapping({"/v1.0/{customerId}"})
	public ResponseEntity<String> getCustomerById(@PathVariable("customerId") long customerId){
		Customer customer=this.customerService.getCustomerById(customerId);
		gson=new Gson();
		if(customer!=null)
			return ResponseEntity.status(HttpStatus.OK)
					.body(gson.toJson(customer));
		else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.body("Customer Not Found");
	}
	
	//delete customer by id
		@DeleteMapping({"/v1.0/{customerId}"})
		public ResponseEntity<String> deleteCustomerById(@PathVariable("customerId") long customerId){
			
			if(this.customerService.deleteCustomerById(customerId))
				return ResponseEntity.status(HttpStatus.OK)
						.body("Customer Deleted");
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Customer Not Found");
		}
		
		@PutMapping({"/v1.0/{customerId}/{firstName}/{lastName}/{middleName}"})
		public ResponseEntity<String> updateCustomerById(@PathVariable("customerId") 
		long customerId, @PathVariable("firstName") 
		String firstName,
		
		@PathVariable("lastName") 
		String lastName)
		{
			FullName fullName=new FullName(firstName,"",lastName);
			Customer customer=this.customerService.updateCustomerById(customerId,
					fullName);
			
		 gson=new Gson();
			if(customer!=null)
				return ResponseEntity.status(HttpStatus.OK)
						.body(gson.toJson(customer));
			else
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body("Customer Not Found");
		}
		
		

	    @GetMapping({"/v1.0/filters/{customerId}"})
	    public ResponseEntity<String> getUserFilteredDataById(@PathVariable("customerId") 
	    long customerId,@RequestParam(name = "fields", required = false) String fields) {
	    	Customer customerObj=this.customerService.getCustomerById(customerId);
	    	
	    	
	    	if(customerObj!=null)
	    	{
	    		//fields refers to runtime selection
	    		ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);     		
				return ResponseEntity.status(HttpStatus.ACCEPTED).
						body(SquigglyUtils.stringify(mapper, customerObj));
				

	    	}
	    	else
	    	{
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Customer Not Available");
	    	}

	    }

	    @GetMapping({"/v1.0/filters"})
	    public ResponseEntity<?> getUserFilteredDataById(@RequestParam(name = "fields", required = false) String fields) {
	    	 Span span = tracer.buildSpan("accessing Filtered customers").start();
	    	List<Customer> customers=this.customerService.getAllCustomers(span);
	    	
	    	
	    	if(customers.size()>0)
	    	{
	    		  span.finish();
	    		//fields refers to runtime selection
	    		ObjectMapper mapper = Squiggly.init(new ObjectMapper(), fields);     		
				return ResponseEntity.status(HttpStatus.ACCEPTED).
						body(SquigglyUtils.listify(mapper, customers));
			

	    	}
	    	else
	    	{
	    		return ResponseEntity.status(HttpStatus.BAD_REQUEST)
	    				.body("customers Not Available");
	    	}
      
	    }
		
		
		
}
