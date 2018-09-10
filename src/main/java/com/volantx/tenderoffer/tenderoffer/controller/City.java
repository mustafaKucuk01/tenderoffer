package com.volantx.tenderoffer.tenderoffer.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class City {

    @GetMapping
    public String city(){
        return "City";
    }

}
