package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.OrderDto;
import com.example.VadarodProject.entity.Order;
import com.example.VadarodProject.mapper.OrderMapper;
import com.example.VadarodProject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public OrderDto addOrder(OrderDto order) {
        return orderMapper.toDto(orderRepository.save(orderMapper.toEntity(order)));
    }

    public void deleteOrder(OrderDto order) {
        orderRepository.delete(orderMapper.toEntity(order));
    }

    public OrderDto findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return orderMapper.toDto(order.orElse(new Order()));
    }

    public List<OrderDto> findAll() {
        return orderMapper.toOrderDtoList((List<Order>) orderRepository.findAll());
    }
}
