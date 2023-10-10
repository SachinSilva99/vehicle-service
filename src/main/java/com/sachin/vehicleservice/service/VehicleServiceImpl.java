package com.sachin.vehicleservice.service;

import com.sachin.vehicleservice.dto.VehicleDTO;
import com.sachin.vehicleservice.entity.Vehicle;
import com.sachin.vehicleservice.entity.VehicleImage;
import com.sachin.vehicleservice.repo.VehicleImageRepo;
import com.sachin.vehicleservice.repo.VehicleRepo;
import com.sachin.vehicleservice.util.mapper.Mapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class VehicleServiceImpl implements VehicleService {
    private final Mapper mapper;
    private final VehicleRepo vehicleRepo;
    private final VehicleImageRepo imageRepo;

    @Override
    @Transactional
    public String createVehicle(VehicleDTO vehicleDTO) {

        Vehicle vehicle = mapper.toVehicle(vehicleDTO);
        Vehicle savedVehicle = vehicleRepo.save(vehicle);

        vehicleDTO.getVehicleImagesStrings().forEach(imageString -> {
            VehicleImage vehicleImage = VehicleImage.builder()
                    .vehicleImageValue(imageString)
                    .vehicle(savedVehicle)
                    .build();
            imageRepo.save(vehicleImage);
            vehicle.getVehicleImages().add(vehicleImage);
        });
        System.out.println("image " + vehicle.getVehicleImages());
        return savedVehicle.getVehicleId();
    }
}
