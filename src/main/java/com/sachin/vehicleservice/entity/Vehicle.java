package com.sachin.vehicleservice.entity;

import com.sachin.vehicleservice.entity.enums.VehicleCategory;
import com.sachin.vehicleservice.entity.enums.VehicleFuelType;
import com.sachin.vehicleservice.entity.enums.VehicleTransmission;
import com.sachin.vehicleservice.entity.enums.VehicleType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicleId;

    @Column(nullable = false)
    private String vehicleBrand;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleCategory vehicleCategory;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleFuelType vehicleFuelType;

    @Column(nullable = false)
    private double vehicleFuelConsumption;

    @Column(nullable = false)
    private Boolean vehicleIsHybrid;

    @Column(nullable = false)
    private int vehicleNoOfSeats;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private VehicleTransmission vehicleTransmission;

    @Column
    private String vehicleRemarks;

    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL)
    private List<VehicleImage> vehicleImages = new ArrayList<>();
}
