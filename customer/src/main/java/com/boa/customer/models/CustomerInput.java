package com.boa.customer.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerInput {
	private long customerId;
	
	private FullNameInput name;

	
	private String gender;


	private String dob;
}
