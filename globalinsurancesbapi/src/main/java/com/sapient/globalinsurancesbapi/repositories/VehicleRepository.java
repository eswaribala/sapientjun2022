package com.sapient.globalinsurancesbapi.repositories;

import com.sapient.globalinsurancesbapi.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
