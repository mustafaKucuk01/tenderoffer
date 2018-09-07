package com.volantx.tenderoffer.tenderoffer.repository;

import com.volantx.tenderoffer.tenderoffer.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Integer> {

     List<Address> findByAddressIdAfter(int id);

     Optional<Address> findByCityLike(String cityName);

     Optional<Address> findByAddressId(int id);

}
