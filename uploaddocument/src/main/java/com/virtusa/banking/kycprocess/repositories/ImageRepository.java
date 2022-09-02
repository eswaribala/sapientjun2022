package com.virtusa.banking.kycprocess.repositories;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.virtusa.banking.kycprocess.models.ImageModel;

public interface ImageRepository extends JpaRepository<ImageModel, Long> {
	Optional<ImageModel> findByName(String name);
}