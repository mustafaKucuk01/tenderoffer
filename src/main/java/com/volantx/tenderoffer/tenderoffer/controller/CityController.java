package com.volantx.tenderoffer.tenderoffer.controller;

import com.volantx.tenderoffer.tenderoffer.entity.City;
import com.volantx.tenderoffer.tenderoffer.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

  /*  @GetMapping
    public String city(){
        return "City";
    }*/

    @GetMapping
    public List<City> list(){ return cityService.all(); }

    @GetMapping("/{id}")
    public City read(@PathVariable("id") Long id){
        return cityService.get(id);
    }

}
