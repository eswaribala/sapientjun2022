package com.boa.customer.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boa.customer.models.Address;
import com.boa.customer.models.Customer;
import com.boa.customer.repositories.AddressRepo;

@Service
public class AddressService {
	@Autowired
	private AddressRepo addressRepo;
	@Autowired
	private CustomerService customerService;
	
	
	public Address addAddress(long customerId,Address address) {
		
		Address addressObj=null;
		Customer customer=this.customerService.getCustomerById(customerId);
		if(customer !=null) {
		 address.setCustomer(customer);
		 addressObj=this.addressRepo.save(address);
		}
		return addressObj;
		
	}
	
	public List<Address> getAllAddresses(){
		return this.addressRepo.findAll();
	}
	
	public Address getAddressById(long addressId) {
		return this.addressRepo.findById(addressId).orElse(null);
	}

}
