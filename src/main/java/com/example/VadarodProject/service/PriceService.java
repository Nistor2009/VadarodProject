package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.PriceDto;
import com.example.VadarodProject.entity.Price;
import com.example.VadarodProject.mapper.PriceMapper;
import com.example.VadarodProject.repository.PriceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PriceService {
    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public PriceDto addPrice(PriceDto price) {
        return priceMapper.toDto(priceRepository.save(priceMapper.toEntity(price)));
    }

    public void deletePrice(PriceDto price) {
        priceRepository.delete(priceMapper.toEntity(price));
    }

    public PriceDto findById(Long id) {
        Optional<Price> price = priceRepository.findById(id);
        return priceMapper.toDto(price.orElse(new Price()));
    }

    public List<PriceDto> findAll() {
        return priceMapper.toPriceDtoList((List<Price>) priceRepository.findAll());
    }
}
