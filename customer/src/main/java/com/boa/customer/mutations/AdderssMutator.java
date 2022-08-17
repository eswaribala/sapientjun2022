package com.boa.customer.mutations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customer.models.Address;
import com.boa.customer.models.AddressInput;
import com.boa.customer.services.AddressService;
import com.boa.customer.services.CustomerService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
@Component
public class AdderssMutator implements GraphQLMutationResolver{
	@Autowired
	private AddressService addressService;
	@Autowired
	private CustomerService customerService;
	
	public Address createAddress(AddressInput addressInput) {
		
		
		return this.addressService.addAddress(addressInput.getCustomer().getCustomerId(),
				new Address(0L,addressInput.getDoorNo(),addressInput.getStreetName(),
						addressInput.getCity(),
						addressInput.getState(),
						addressInput.getCountry(),null));
		
	}
	
	
}
