package com.boa.customer.mutations;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customer.models.Address;
import com.boa.customer.models.AddressInput;
import com.boa.customer.models.Customer;
import com.boa.customer.models.CustomerInput;
import com.boa.customer.models.FullName;
import com.boa.customer.models.Gender;

import com.boa.customer.services.CustomerService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
@Component
public class CustomerMutation implements GraphQLMutationResolver{
	
	@Autowired
	private CustomerService customerService;
	
	public Customer createCustomer(CustomerInput customerInput) {
		
		
		return this.customerService.addCustomer(new Customer(0,new FullName(
				customerInput.getName().getFirstName(),
				customerInput.getName().getMiddleName(),
				customerInput.getName().getLastName()),
				Gender.valueOf(customerInput.getGender()),
						LocalDate.parse(customerInput.getDob())));
	}
}