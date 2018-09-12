package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.District;
import com.volantx.tenderoffer.tenderoffer.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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

        District d1 = new District("İmamoğlu", cityService.get(1l));
        District d2 = new District("Kozan", cityService.get(1l));

        try {
            Stream.of(d1, d2).forEach(this::addDistrict);
        } catch (Exception e) {

        }
    }

    public List<District> all(){return districtRepository.findAll();}

    public District addDistrict(District district){
        System.out.println("Adding district :" + district.toString());
        Optional<District> byName = districtRepository.findById(district.getId());
        if (byName.isPresent()){
            throw new RuntimeException("District is already added");
        }
        return districtRepository.save(district);
    }

    public District updateDistrict(Long id, District district){
        Optional<District> byId = districtRepository.findById(id);
        getDistrict(id);
        district.setId(id);
        if (byId.isPresent() && !byId.get().getId().equals(district.getId())){
            System.out.println("Already added");
            throw new RuntimeException("Already added");
        }
        return districtRepository.save(district);
    }

    public void deleteDistrict(Long id){
        districtRepository.delete(getDistrict(id));
    }


    public District getDistrict(Long id){
        System.out.println("Get district : " + id);
        Optional<District> byId = districtRepository.findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Use not found");
        }
        return byId.get();
    }


}
