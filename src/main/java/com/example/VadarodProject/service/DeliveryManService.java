package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.DeliveryManDto;
import com.example.VadarodProject.entity.DeliveryMan;
import com.example.VadarodProject.mapper.DeliveryManMapper;
import com.example.VadarodProject.repository.DeliveryManRepository;
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
public class DeliveryManService {
    private final DeliveryManRepository deliveryManRepository;
    private final DeliveryManMapper deliveryManMapper;

    public DeliveryManDto addDeliveryMan(DeliveryManDto deliveryMan) {
        return deliveryManMapper.toDto(deliveryManRepository.save(deliveryManMapper.toEntity(deliveryMan)));
    }

    public DeliveryManDto deleteDeliveryMan(DeliveryManDto deliveryMan) {
        deliveryManRepository.delete(deliveryManMapper.toEntity(deliveryMan));
        return deliveryMan;
    }

    public DeliveryManDto findById(Long id) {
        Optional<DeliveryMan> deliveryMan = deliveryManRepository.findById(id);
        return deliveryManMapper.toDto(deliveryMan.orElse(new DeliveryMan()));
    }

    public List<DeliveryManDto> findAll(int page,
                                        int size,
                                        String sort,
                                        Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        Page<DeliveryMan> pageClient = deliveryManRepository.findAll(pageable);
        return deliveryManMapper.toDeliveryManDtoList(pageClient.get().toList());
    }
}
