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
        City c3 = new City("Ankara");

        try {
            Stream.of(c1, c2, c3).forEach(this::addCity);
        } catch (Exception e) {
           // System.err.println("CityService -> run method");
            //e.printStackTrace();
        }

    }

    public List<City> all(){
        return cityRepository.findAll();
    }

    public City addCity(City city) {
        System.out.println("Adding city "+ city.toString());
        Optional<City> byName = cityRepository.findByName(city.getName());
        if (byName.isPresent()){
            throw new RuntimeException("City Already added");
        }
        return cityRepository.save(city);
    }

    public City updateCity(Long id, City city){

        return cityRepository.save(city);
    }

    public void deleteCity(Long id){
         cityRepository.delete(get(id));
    }

    public City get(Long id){
        return cityRepository.findById(id).get();
    }

    public City getByName(String name){
        Optional<City> city = cityRepository.findByName(name);
        return city.get();
    }

    public void deleteByName(String name){
        deleteCity(getByName(name).getId());
    }
}
