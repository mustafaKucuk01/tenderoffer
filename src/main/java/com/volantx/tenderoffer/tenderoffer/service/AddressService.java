package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.Address;
import com.volantx.tenderoffer.tenderoffer.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AddressService implements ApplicationRunner {

    private AddressRepository addressRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Address a1 = new Address(cityService.get(1l), districtService.getDistrict(1l));
        Address a2 = new Address(cityService.get(1l), districtService.getDistrict(2l));

        System.out.println(a1.toString());
        System.out.println(a2.toString());

        try {
            Stream.of(a1, a2).forEach(this::addAddress);
        } catch (Exception e) {

        }
    }

    public List<Address> all(){return addressRepository.findAll();}

    public Address addAddress(Address address){
        System.out.println("Adding address :" + address.toString());
        Optional<Address> byId = addressRepository.findById(address.getAddressId());
        if (byId.isPresent()){
            throw new RuntimeException("Adress is already added");
        }
        return addressRepository.save(address);
    }

}
