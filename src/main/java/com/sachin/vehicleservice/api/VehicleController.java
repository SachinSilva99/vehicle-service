package com.sachin.vehicleservice.api;

import com.sachin.vehicleservice.dto.VehicleDTO;
import com.sachin.vehicleservice.service.VehicleService;
import com.sachin.vehicleservice.util.StandardResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/vehicles", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StandardResponse> createVehicle(
            @RequestPart VehicleDTO vehicleDTO,
            @RequestPart List<MultipartFile> vehicleImages
    ) {

        List<String> imageList = vehicleImages.stream().map(multipartFile -> {
            try {
                return Base64.getEncoder().encodeToString(multipartFile.getBytes());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).toList();
        vehicleDTO.setVehicleImagesStrings(imageList);
//        System.out.println(vehicleDTO);
//        System.out.println(vehicleImages);
        String vehicleId = vehicleService.createVehicle(vehicleDTO);
        return new ResponseEntity<>(
                new StandardResponse(HttpStatus.CREATED.value(), "OK", vehicleId),
                HttpStatus.CREATED);
    }
}
