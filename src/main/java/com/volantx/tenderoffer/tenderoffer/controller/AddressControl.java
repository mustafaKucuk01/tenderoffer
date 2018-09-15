package com.volantx.tenderoffer.tenderoffer.controller;

import com.volantx.tenderoffer.tenderoffer.entity.Address;
import com.volantx.tenderoffer.tenderoffer.service.AddressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
public class AddressControl {

    private AddressService addressService;

    public AddressControl(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public List<Address> listAddresses(){ return addressService.all(); }

    @GetMapping("/{id}")
    public Address readAddress(@PathVariable("id") Long id){
        return addressService.getAddress(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAddress(@PathVariable("id") Long id){
        addressService.deleteAddress(id);
    }

    @PostMapping
    public Address addAddress(@RequestBody Address address){
        return addressService.addAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable("id")Long id,@RequestBody Address address){
        return addressService.updateAddress(id, address);
    }


}
