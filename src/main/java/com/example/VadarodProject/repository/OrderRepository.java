package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository  extends CrudRepository<Order, Long> {
}
