package com.volantx.tenderoffer.tenderoffer.repository;

import com.volantx.tenderoffer.tenderoffer.entity.Adress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressRepository extends JpaRepository<Adress, Integer> {
     List<Adress> findByAddressIdAfter(int id);

     Adress findAllByCityLike(String city);
}
