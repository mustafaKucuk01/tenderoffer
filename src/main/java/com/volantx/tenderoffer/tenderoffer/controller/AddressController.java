package com.volantx.tenderoffer.tenderoffer.controller;

import com.volantx.tenderoffer.tenderoffer.entity.Address;
import com.volantx.tenderoffer.tenderoffer.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

public class AddressController {
    private AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> list(){return addressService.getAllAddresses();}
}
