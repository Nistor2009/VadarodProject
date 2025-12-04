package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.CureDto;
import com.example.VadarodProject.entity.Cure;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-04T21:08:21+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class CureMapperImpl implements CureMapper {

    @Override
    public CureDto toDto(Cure cure) {
        if ( cure == null ) {
            return null;
        }

        CureDto cureDto = new CureDto();

        cureDto.setId( cure.getId() );
        cureDto.setName( cure.getName() );
        cureDto.setNeedRecipe( cure.isNeedRecipe() );

        return cureDto;
    }

    @Override
    public Cure toEntity(CureDto cureDto) {
        if ( cureDto == null ) {
            return null;
        }

        Cure cure = new Cure();

        cure.setId( cureDto.getId() );
        cure.setName( cureDto.getName() );
        cure.setNeedRecipe( cureDto.isNeedRecipe() );

        return cure;
    }

    @Override
    public List<CureDto> toCureDtoList(List<Cure> cures) {
        if ( cures == null ) {
            return null;
        }

        List<CureDto> list = new ArrayList<CureDto>( cures.size() );
        for ( Cure cure : cures ) {
            list.add( toDto( cure ) );
        }

        return list;
    }

    @Override
    public List<Cure> toCureList(List<CureDto> Dtos) {
        if ( Dtos == null ) {
            return null;
        }

        List<Cure> list = new ArrayList<Cure>( Dtos.size() );
        for ( CureDto cureDto : Dtos ) {
            list.add( toEntity( cureDto ) );
        }

        return list;
    }
}
