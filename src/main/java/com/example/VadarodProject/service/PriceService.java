package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.PriceDto;
import com.example.VadarodProject.entity.Price;
import com.example.VadarodProject.mapper.PriceMapper;
import com.example.VadarodProject.repository.PriceRepository;
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
public class PriceService {
    private final PriceRepository priceRepository;
    private final PriceMapper priceMapper;

    public PriceDto addPrice(PriceDto price) {
        return priceMapper.toDto(priceRepository.save(priceMapper.toEntity(price)));
    }

    public PriceDto deletePrice(PriceDto price) {
        priceRepository.delete(priceMapper.toEntity(price));
        return price;
    }

    public PriceDto findById(Long id) {
        Optional<Price> price = priceRepository.findById(id);
        return priceMapper.toDto(price.orElse(new Price()));
    }

    public List<PriceDto> findAll(int page,
                                  int size,
                                  String sort,
                                  Sort.Direction sortDirection) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));
        Page<Price> pageClient = priceRepository.findAll(pageable);
        return priceMapper.toPriceDtoList(pageClient.get().toList());
    }
}
