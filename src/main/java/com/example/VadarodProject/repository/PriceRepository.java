package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Price;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface PriceRepository  extends CrudRepository<Price, Long> {
    Page<Price> findAll(Pageable pageable);
}
