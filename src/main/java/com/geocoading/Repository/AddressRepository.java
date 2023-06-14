package com.geocoading.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.geocoading.Entity.Address;

public interface AddressRepository extends JpaRepository<Address,Long > {

}
