package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.District;
import com.volantx.tenderoffer.tenderoffer.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class DistrictService implements ApplicationRunner {

    private DistrictRepository districtRepository;

    @Autowired
    private CityService cityService;


    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        District d1 = new District("İmamoğlu", cityService.getByName("Adana"));
        District d2 = new District("Kozan", cityService.getByName("Adana"));

        try {
            Stream.of(d1, d2).forEach(this::addDistrict);
        } catch (Exception e) {

        }
    }

    public List<District> all (){return districtRepository.findAll();}

    public District addDistrict(District district){
        System.out.println("Adding district :" + district.toString());
        return districtRepository.save(district);
    }
}
