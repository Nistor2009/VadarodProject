package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.CureDto;
import com.example.VadarodProject.entity.Cure;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CureMapper {
    CureDto toDto(Cure cure);

    Cure toEntity(CureDto cureDto);

    List<CureDto> toCureDtoList(List<Cure> cures);

    List<Cure> toCureList(List<CureDto> Dtos);
}
