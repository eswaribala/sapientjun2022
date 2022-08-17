package com.boa.customer.queryresolvers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.boa.customer.models.Address;
import com.boa.customer.services.AddressService;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class AddressResolver  implements GraphQLQueryResolver{
	@Autowired
	private AddressService addressService;
	
	public List<Address> findAllAddresses(){
		return this.addressService.getAllAddresses();
	}
	public Address findAddress(long addressId){
		return this.addressService.getAddressById(addressId);
	}
}
