package com.volantx.tenderoffer.tenderoffer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/districts")
public class DistrictController {

    @GetMapping
    public String sayHello(){
        return "Hello from DistrictController";
    }
}
