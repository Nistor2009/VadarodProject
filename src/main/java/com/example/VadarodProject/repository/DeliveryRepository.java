package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Delivery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryRepository  extends CrudRepository<Delivery, Long> {
    Page<Delivery> findAll(Pageable pageable);
}
