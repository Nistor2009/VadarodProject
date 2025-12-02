package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<Order, Long> {
    Page<Order> findAll(Pageable pageable);
}
