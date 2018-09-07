package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.repository.OrderRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.jpa.repository.JpaRepository;

public class OrderService implements ApplicationRunner {

    private OrderRepository orderRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }
}
