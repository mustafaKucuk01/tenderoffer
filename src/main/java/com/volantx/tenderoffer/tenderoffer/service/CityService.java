package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.City;
import com.volantx.tenderoffer.tenderoffer.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CityService implements ApplicationRunner {

    @Autowired
    private CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        City c1 = new City("Adana");
        City c2 = new City("Adıyaman");
        City c3 = new City("Ankara");

        try {
            Stream.of(c1, c2, c3).forEach(this::addCity);
        } catch (Exception e) {

        }

    }

    public List<City> all(){
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        System.out.println("Adding city "+ city.toString());
        Optional<City> byname = cityRepository.findByName(city.getName());
        //Optional<City> byId = cityRepository.findById(city.getId());
        if (byname.isPresent()){
            throw new RuntimeException("City Already added");
        }
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city){
        System.out.println("simdilik bos kalsın");
        return cityRepository.save(city);
    }

    public void deleteCity(Long id){
        System.out.println("simdilik bos kalsın");
        cityRepository.delete(get(id));
    }

    public City get(Long id){
        System.out.println("Get city " + id);
        Optional<City> byId = cityRepository.findById(id);
        if (!byId.isPresent()) {
            throw new RuntimeException("Use not found");
        }
        return byId.get();
    }

    public City getCityWithName(String name){
        System.out.println("Get City :" + name);
        Optional<City> byName = cityRepository.findByName(name);
        if (!byName.isPresent()){
            throw new RuntimeException("City not found with name :" + name);
        }
        return byName.get();
    }



}
