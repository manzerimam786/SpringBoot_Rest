package com.example.service;

import com.example.entity.Address;
import com.example.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;


    public Address createAddress(@Valid Address address) {
        return addressRepository.save(address);
    }

    public Address getAddress(Long addressId) {
        return addressRepository.findByAddressId(addressId);
    }
}
