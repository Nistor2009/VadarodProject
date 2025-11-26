package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.PharmacyDto;
import com.example.VadarodProject.entity.Pharmacy;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PharmacyMapper {
    PharmacyDto toDto(Pharmacy pharmacy);

    Pharmacy toEntity(PharmacyDto dto);

    List<PharmacyDto> toPharmacyDtoList(List<Pharmacy> pharmacies);

    List<Pharmacy> toPharmacyList(List<PharmacyDto> Dtos);
}
