package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.Adress;
import com.volantx.tenderoffer.tenderoffer.repository.AddressRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

public class AddressService implements ApplicationRunner {

    AddressRepository addressRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    public List<Adress> getAllAddresses(){
        return addressRepository.findAll();
    }
}
