package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.DeliveryDto;
import com.example.VadarodProject.entity.Delivery;
import com.example.VadarodProject.mapper.DeliveryMapper;
import com.example.VadarodProject.repository.DeliveryRepository;
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

    public List<DeliveryDto> findAll(int page,
                                     int size,
                                     String sort,
                                     Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        Page<Delivery> pageClient = deliveryRepository.findAll(pageable);
        return deliveryMapper.toDeliveryDtoList(pageClient.get().toList());
    }
}
