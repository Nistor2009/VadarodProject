package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.PriceDto;
import com.example.VadarodProject.entity.Price;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PriceMapper {
    PriceDto toDto(Price price);

    Price toEntity(PriceDto dto);

    List<PriceDto> toPriceDtoList(List<Price> prices);

    List<Price> toPriceList(List<PriceDto> Dtos);
}
