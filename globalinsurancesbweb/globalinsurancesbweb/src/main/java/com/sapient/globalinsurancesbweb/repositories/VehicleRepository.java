package com.sapient.globalinsurancesbweb.repositories;


import com.sapient.globalinsurancesbweb.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
