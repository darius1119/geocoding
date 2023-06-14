package com.geocoading.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geocoading.Entity.Address;
import com.geocoading.Service.GeocodingService;

@RestController
@RequestMapping("/api/geocoding")
public class GeocodingController {
    private final GeocodingService geocodingService;

    @Autowired
    public GeocodingController(GeocodingService geocodingService) {
        this.geocodingService = geocodingService;
    }

    // Define RESTful endpoints for geocoding requests

    @PostMapping("/single")
    public ResponseEntity<Address> geocodeSingleAddress(@RequestBody Address address) {
        // Call geocoding service method to process single address
        Address geocodedAddress = geocodingService.geocodeSingleAddress(address);
        return ResponseEntity.status(HttpStatus.OK).body(geocodedAddress);
    }

    @PostMapping("/batch")
    public ResponseEntity<String> geocodeBatchAddresses(@RequestBody List<Address> addresses) {
        // Call geocoding service method to process batch addresses
        String result = geocodingService.geocodeBatchAddresses(addresses);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
