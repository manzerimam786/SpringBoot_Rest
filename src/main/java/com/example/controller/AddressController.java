package com.example.controller;

import com.example.entity.Address;
import com.example.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/adddresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @PostMapping("/createAddress")
    public ResponseEntity<Address> createAddress(@RequestBody @Valid Address address) {
        Address responseAddress = addressService.createAddress(address);
        return new ResponseEntity<>(responseAddress, HttpStatus.OK);
    }

    @GetMapping("/adddressId")
    public ResponseEntity<Address> getAddress(@PathVariable("addressId")Integer addressId){
        Address address = addressService.getAddress(addressId);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }
}
