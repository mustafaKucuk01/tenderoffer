package com.volantx.tenderoffer.tenderoffer.repository;

import com.volantx.tenderoffer.tenderoffer.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
