package com.sachin.vehicleservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
public class VehicleImage {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String vehicleImageId;

    @Column(nullable = false, columnDefinition = "LongText")
    @Lob
    private String vehicleImageValue;

    @ManyToOne
    private Vehicle vehicle;
}
