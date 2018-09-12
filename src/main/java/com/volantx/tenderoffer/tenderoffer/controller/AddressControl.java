package com.volantx.tenderoffer.tenderoffer.controller;

import com.volantx.tenderoffer.tenderoffer.entity.Address;
import com.volantx.tenderoffer.tenderoffer.service.AddressService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressControl {

    private AddressService addressService;

    public AddressControl(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> list(){ return addressService.all(); }

}
