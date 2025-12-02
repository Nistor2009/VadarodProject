package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.DeliveryDto;
import com.example.VadarodProject.entity.Delivery;
import com.example.VadarodProject.mapper.DeliveryMapper;
import com.example.VadarodProject.repository.DeliveryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    private final DeliveryRepository deliveryRepository;
    private final DeliveryMapper deliveryMapper;

    public DeliveryDto addDelivery(DeliveryDto delivery) {
        return deliveryMapper.toDto(deliveryRepository.save(deliveryMapper.toEntity(delivery)));
    }

    public DeliveryDto deleteDelivery(DeliveryDto delivery) {
        deliveryRepository.delete(deliveryMapper.toEntity(delivery));
        return delivery;
    }

    public DeliveryDto findById(Long id) {
        Optional<Delivery> delivery = deliveryRepository.findById(id);
        return deliveryMapper.toDto(delivery.orElse(new Delivery()));
    }

    public List<DeliveryDto> findAll() {
        return deliveryMapper.toDeliveryDtoList((List<Delivery>) deliveryRepository.findAll());
    }
}
