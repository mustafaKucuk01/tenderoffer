package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.City;
import com.volantx.tenderoffer.tenderoffer.repository.CityRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CityService implements ApplicationRunner {

    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        City c1 = new City("Adana");
        City c2 = new City("Adıyaman");

        System.out.println(c1.getName() + " " + c1.getId());
        System.out.println(c2.getName() + " " + c2.getId());

        try {
            Stream.of(c1, c2).forEach(this::addCity);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public List<City> all(){
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        System.out.println("Adding city "+ city.toString());
      /*  Optional<City> byId = cityRepository.findById(city.getId());
        if (byId.isPresent()){
            System.out.println("Already added");
            throw new RuntimeException("Already added");
        }*/
        return cityRepository.save(city);
    }
}
