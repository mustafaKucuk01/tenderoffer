package com.volantx.tenderoffer.tenderoffer.service;

import com.volantx.tenderoffer.tenderoffer.entity.Address;
import com.volantx.tenderoffer.tenderoffer.entity.Customer;
import com.volantx.tenderoffer.tenderoffer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CustomerService implements ApplicationRunner {

    private CustomerRepository customerRepository;

    @Autowired
    private AddressService addressService;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Customer c1 = new Customer("Mustafa", "Küçük", "5457375317", "mustafa@gmail.com",
                new ArrayList<>());
        c1.getAddress().add(addressService.getAddress(66l));

        try {
            Stream.of(c1).forEach(this::addCustomer);
        } catch (Exception e) {

        }

    }

    List<Customer> listAll(){
        return customerRepository.findAll();
    }

    public Customer addCustomer(Customer customer){
        System.out.println("Adding customer :" + customer.toString());

        Optional<Customer> byEmail = customerRepository.findByEmail((customer.getEmail()));
        //Optional<Customer> byId = customerRepository.findById(customer.getId());
        if (byEmail.isPresent()){
            throw new RuntimeException("Customer already added :" + customer.toString());
        }
        return customerRepository.save(customer);
    }

    public Customer getCustomer(Long id){
        Optional<Customer> byId = customerRepository.findById(id);
        if (!byId.isPresent()){
            throw new RuntimeException("Customer not founded" );
        }
        return customerRepository.getOne(id);
    }

    public void deleteCustomer(Long id){
        System.out.println("Deleting customer :" + getCustomer(id).toString());
        customerRepository.delete(getCustomer(id));
    }

    public Customer updateCustomer(Long id, Customer customer){
        getCustomer(id);
        customer.setId(id);

        return customerRepository.save(customer);
    }
}
