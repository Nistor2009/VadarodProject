package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.DeliveryMan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface DeliveryManRepository  extends CrudRepository<DeliveryMan, Long> {
    Page<DeliveryMan> findAll(Pageable pageable);
}
