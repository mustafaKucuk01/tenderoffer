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

    @Autowired
    private DistrictRepository districtRepository;

    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Autowired
    private CityService cityService;



    @Override
    public void run(ApplicationArguments args) throws Exception {

        District d1 = new District("İmamoğlu", cityService.getCityWithName("Adana"));
        District d2 = new District("Kozan", cityService.getCityWithName("Adana"));

        System.out.println(cityService.getCityWithName("Adana").toString());

        try {
            Stream.of(d1, d2).forEach(this::addDistrict);
        } catch (Exception e) {

        }
    }

    public List<District> all(){return districtRepository.findAll();}

    public District addDistrict(District district){
        System.out.println("Adding district :" + district.toString());
        Optional<District> byName = districtRepository.findByName(district.getName());
        if (byName.isPresent()){
            throw new RuntimeException("District is already added");
        }
        return districtRepository.save(district);
    }

    public District updateDistrict(Long id, District district){
        getDistrict(id);
        district.setId(id);

        return districtRepository.save(district);
    }

    public void deleteDistrict(Long id){
        districtRepository.delete(getDistrict(id));
    }


    // Bu metot sıkıntılı ama kullanmadığım için surmasında sıkıntı yok, silmiyorum
    public District getDistrict(Long id){
        System.out.println("Get district : " + id);
        Optional<District> byId = districtRepository.findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Use not found");
        }
        return byId.get();
    }

    public District getDistrictWithName(String name){
        System.out.println("Get District :" + name);
        Optional<District> byName = districtRepository.findByName(name);
        if (!byName.isPresent()){
            throw new RuntimeException("District not found with name :" + name);
        }
        return byName.get();
    }
}
