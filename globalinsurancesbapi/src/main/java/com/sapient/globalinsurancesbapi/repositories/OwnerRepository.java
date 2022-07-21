package com.sapient.globalinsurancesbapi.repositories;

import com.sapient.globalinsurancesbapi.models.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner,Long> {
}
