package com.boa.customer.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boa.customer.models.Address;

public interface AddressRepo extends JpaRepository<Address,Long>{

}
