package com.sachin.vehicleservice.repo;

import com.sachin.vehicleservice.entity.VehicleImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleImageRepo extends JpaRepository<VehicleImage, String> {
}
