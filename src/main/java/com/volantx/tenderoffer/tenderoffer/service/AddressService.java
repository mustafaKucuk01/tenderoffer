package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.Address;
import com.volantx.tenderoffer.tenderoffer.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class AddressService implements ApplicationRunner {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private CityService cityService;

    @Autowired
    private DistrictService districtService;



    public AddressService() {
    }

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }



    @Override
    public void run(ApplicationArguments args) throws Exception {
        Address a1 = new Address(cityService.getCityWithName("Adana"), districtService.getDistrictWithName("İmamoğlu"));
        Address a2 = new Address(cityService.getCityWithName("Adana"), districtService.getDistrictWithName("Kozan"));

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
        Optional<Address> byId = addressRepository.findByAddressId(address.getAddressId());
        if (byId.isPresent()){
            throw new RuntimeException("Adress is already added");
        }
        return addressRepository.save(address);
    }

    public Address getAddress(Long id){
        Optional<Address> byId = addressRepository.findByAddressId(id);
        if (!byId.isPresent()){
            throw new RuntimeException("Adress not founded");
        }
        return byId.get();
    }

    public Address updateAddress(Long id, Address address){

        getAddress(id);
        address.setAddressId(id);
        return addressRepository.save(address);
    }

    public void deleteAddress(Long id){
        System.out.println("Deleting the address :" + getAddress(id).toString());
        addressRepository.delete(getAddress(id));
    }

    
}
