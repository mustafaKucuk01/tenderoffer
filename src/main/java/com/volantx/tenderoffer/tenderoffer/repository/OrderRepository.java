package com.volantx.tenderoffer.tenderoffer.repository;

import com.volantx.tenderoffer.tenderoffer.entity.Customer;
import com.volantx.tenderoffer.tenderoffer.entity.Orderr;
import com.volantx.tenderoffer.tenderoffer.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Orderr, Long> {

    Optional<Orderr> findById(Long id);

    Optional<Orderr> findByCustomer(Customer customer);

    Optional<Orderr> findByProduct(Product product);

}
