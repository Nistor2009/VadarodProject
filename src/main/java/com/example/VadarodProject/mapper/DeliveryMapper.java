package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.DeliveryDto;
import com.example.VadarodProject.entity.Delivery;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryMapper {
    DeliveryDto toDto(Delivery delivery);

    Delivery toEntity(DeliveryDto dto);

    List<DeliveryDto> toDeliveryDtoList(List<Delivery> deliveries);

    List<Delivery> toDeliveryList(List<DeliveryDto> Dtos);
}
