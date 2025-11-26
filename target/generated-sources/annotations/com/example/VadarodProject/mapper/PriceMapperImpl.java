package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.PriceDto;
import com.example.VadarodProject.entity.Price;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T21:08:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class PriceMapperImpl implements PriceMapper {

    @Override
    public PriceDto toDto(Price price) {
        if ( price == null ) {
            return null;
        }

        PriceDto priceDto = new PriceDto();

        priceDto.setId( price.getId() );
        priceDto.setCure( price.getCure() );
        priceDto.setPrice( price.getPrice() );
        priceDto.setPharmacy( price.getPharmacy() );

        return priceDto;
    }

    @Override
    public Price toEntity(PriceDto dto) {
        if ( dto == null ) {
            return null;
        }

        Price price = new Price();

        price.setId( dto.getId() );
        price.setCure( dto.getCure() );
        price.setPrice( dto.getPrice() );
        price.setPharmacy( dto.getPharmacy() );

        return price;
    }

    @Override
    public List<PriceDto> toPriceDtoList(List<Price> prices) {
        if ( prices == null ) {
            return null;
        }

        List<PriceDto> list = new ArrayList<PriceDto>( prices.size() );
        for ( Price price : prices ) {
            list.add( toDto( price ) );
        }

        return list;
    }

    @Override
    public List<Price> toPriceList(List<PriceDto> Dtos) {
        if ( Dtos == null ) {
            return null;
        }

        List<Price> list = new ArrayList<Price>( Dtos.size() );
        for ( PriceDto priceDto : Dtos ) {
            list.add( toEntity( priceDto ) );
        }

        return list;
    }
}
