package com.boa.customer.models;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressInput {

	
	private long addressId;
	
	private String doorNo;

	private String streetName;

	private String city;
	
	private String state;
	
	private String country;

	private CustomerAddressInput customer;
	

}
