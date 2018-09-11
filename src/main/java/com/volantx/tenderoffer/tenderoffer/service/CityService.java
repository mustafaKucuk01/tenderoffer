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


        try {
            Stream.of(c1, c2).forEach(this::addCity);
        } catch (Exception e) {
            System.err.println("CityService -> run method");
            e.printStackTrace();
        }

    }

    public List<City> all(){
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        System.out.println("Adding city "+ city.toString());

        return cityRepository.save(city);
    }
}
