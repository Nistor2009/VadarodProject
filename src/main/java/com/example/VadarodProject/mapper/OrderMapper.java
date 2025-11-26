package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.OrderDto;
import com.example.VadarodProject.entity.Order;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);

    Order toEntity(OrderDto dto);

    List<OrderDto> toOrderDtoList(List<Order> orders);

    List<Order> toOrderList(List<OrderDto> Dtos);
}
