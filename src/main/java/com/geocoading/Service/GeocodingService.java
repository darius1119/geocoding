package com.geocoading.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.geocoading.Entity.Address;
import com.geocoading.Repository.AddressRepository;

@Service
public class GeocodingService {
    private final AddressRepository addressRepository;

    @Autowired
    public GeocodingService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public Address geocodeSingleAddress(Address address) {
        // Implement geocoding logic for a single address
        // You can make API requests to the geocoding service and process the response

        // Example: Setting latitude and longitude based on dummy values
        address.setLatitude(37.7749);
        address.setLongitude(-122.4194);

        // Save the geocoded address to the database
        Address geocodedAddress = addressRepository.save(address);

        return geocodedAddress;
    }

    public String geocodeBatchAddresses(List<Address> addresses) {
        // Implement geocoding logic for batch addresses
        // Iterate through the list of addresses and perform geocoding for each address
        // You can make API requests to the geocoding service and process the response

        // Example: Setting latitude and longitude for each address based on dummy values
        for (Address address : addresses) {
            address.setLatitude(37.7749);
            address.setLongitude(-122.4194);
        }

        // Save the geocoded addresses to the database
        List<Address> geocodedAddresses = addressRepository.saveAll(addresses);

        // Return a result message
        return "Geocoding completed for " + geocodedAddresses.size() + " addresses.";
    }
}
