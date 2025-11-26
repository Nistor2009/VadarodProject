package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.DeliveryManDto;
import com.example.VadarodProject.entity.DeliveryMan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DeliveryManMapper {
    DeliveryManDto toDto(DeliveryMan deliveryMan);

    DeliveryMan toEntity(DeliveryManDto dto);

    List<DeliveryManDto> toDeliveryManDtoList(List<DeliveryMan> deliveryMEN);

    List<DeliveryMan> toDeliveryManList(List<DeliveryManDto> Dtos);
}
