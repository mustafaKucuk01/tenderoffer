package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.Customer;
import com.volantx.tenderoffer.tenderoffer.repository.CustomerRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;

import java.util.List;

public class CustomerService implements ApplicationRunner {

    private CustomerRepository customerRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

    }

    public List<Customer> getAllCustomers(){return customerRepository.findAll();}

}
