package com.volantx.tenderoffer.tenderoffer.repository;

import com.volantx.tenderoffer.tenderoffer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
