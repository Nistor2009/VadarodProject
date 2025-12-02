package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Pharmacy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PharmacyRepository  extends CrudRepository<Pharmacy, Long> {
    Page<Pharmacy> findAll(Pageable pageable);
}
