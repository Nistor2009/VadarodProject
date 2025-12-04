package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.OrderDto;
import com.example.VadarodProject.entity.Order;
import com.example.VadarodProject.mapper.OrderMapper;
import com.example.VadarodProject.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    public OrderDto deleteOrder(OrderDto order) {
        orderRepository.delete(orderMapper.toEntity(order));
        return order;
    }

    public OrderDto findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return orderMapper.toDto(order.orElse(new Order()));
    }

    public List<OrderDto> findAll(int page,
                                  int size,
                                  String sort,
                                  Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        Page<Order> pageClient = orderRepository.findAll(pageable);
        return orderMapper.toOrderDtoList(pageClient.get().toList());
    }
}
