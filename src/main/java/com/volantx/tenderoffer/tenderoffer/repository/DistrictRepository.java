package com.volantx.tenderoffer.tenderoffer.repository;

import com.volantx.tenderoffer.tenderoffer.entity.District;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DistrictRepository extends JpaRepository<District, Long> {

    Optional<District> findById(Long id);

    Optional<District> findByName(String name);

}
