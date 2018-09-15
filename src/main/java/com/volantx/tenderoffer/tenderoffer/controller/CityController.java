package com.volantx.tenderoffer.tenderoffer.controller;

import com.volantx.tenderoffer.tenderoffer.entity.City;
import com.volantx.tenderoffer.tenderoffer.service.CityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping
    public List<City> listCities(){ return cityService.all(); }

    @GetMapping("/{id}")
    public City readCity(@PathVariable("id") Long id){
        return cityService.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteCity(@PathVariable("id") Long id){
        cityService.deleteCity(id);
    }

    @PostMapping
    public City addCity(@RequestBody City city){
        return cityService.addCity(city);
    }

    @PutMapping("/{id}")
    public City updateCity(@PathVariable("id")Long id,@RequestBody City city){
        return cityService.updateCity(id,city);
    }

}
