package com.volantx.tenderoffer.tenderoffer.controller;

import com.volantx.tenderoffer.tenderoffer.entity.District;
import com.volantx.tenderoffer.tenderoffer.service.DistrictService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    private DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping
    public List<District> listDistricts(){
        return districtService.all();
    }

    @GetMapping("/{id}")
    public District readDistrict(@PathVariable("id") Long id){
        return districtService.getDistrict(id);
    }

    @DeleteMapping("/{id}")
    public void deleteDistrict(@PathVariable("id") Long id){
        districtService.deleteDistrict(id);
    }

    @PostMapping
    public District addDistrict(@RequestBody District district){
        return districtService.addDistrict(district);
    }

    @PutMapping("/{id}")
    public District updateDistrict(@PathVariable("id")Long id,@RequestBody District district){
        return districtService.updateDistrict(id, district);
    }
}
