package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.Address;
import com.volantx.tenderoffer.tenderoffer.entity.City;
import com.volantx.tenderoffer.tenderoffer.entity.District;
import com.volantx.tenderoffer.tenderoffer.repository.AddressRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;
import java.util.Optional;

public class AddressService implements ApplicationRunner {

    AddressRepository addressRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        City adana = new City(01, 322, "Adana");
        District imamoglu =  new District(1700, adana, "İmamoğlu");
        Address address1 = new Address(adana, imamoglu);

        addAddress(address1);
    }

    public List<Address> getAllAddresses(){
        return addressRepository.findAll();
    }

    public Address addAddress(Address address){
        System.out.println("Add Address method");
        Optional<Address> byId = addressRepository.findById(address.getAddressId());
        if (byId.isPresent()){
            System.out.println("The address is already added");
        }
        return addressRepository.save(address);
    }
}
