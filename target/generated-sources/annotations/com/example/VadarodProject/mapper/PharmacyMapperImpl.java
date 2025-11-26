package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.PharmacyDto;
import com.example.VadarodProject.entity.Pharmacy;
import com.example.VadarodProject.entity.Price;
import com.example.VadarodProject.entity.Review;
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
public class PharmacyMapperImpl implements PharmacyMapper {

    @Override
    public PharmacyDto toDto(Pharmacy pharmacy) {
        if ( pharmacy == null ) {
            return null;
        }

        PharmacyDto pharmacyDto = new PharmacyDto();

        pharmacyDto.setId( pharmacy.getId() );
        pharmacyDto.setName( pharmacy.getName() );
        List<Price> list = pharmacy.getPrices();
        if ( list != null ) {
            pharmacyDto.setPrices( new ArrayList<Price>( list ) );
        }
        pharmacyDto.setAddress( pharmacy.getAddress() );
        List<Review> list1 = pharmacy.getReviews();
        if ( list1 != null ) {
            pharmacyDto.setReviews( new ArrayList<Review>( list1 ) );
        }

        return pharmacyDto;
    }

    @Override
    public Pharmacy toEntity(PharmacyDto dto) {
        if ( dto == null ) {
            return null;
        }

        Pharmacy pharmacy = new Pharmacy();

        pharmacy.setId( dto.getId() );
        pharmacy.setName( dto.getName() );
        List<Price> list = dto.getPrices();
        if ( list != null ) {
            pharmacy.setPrices( new ArrayList<Price>( list ) );
        }
        pharmacy.setAddress( dto.getAddress() );
        List<Review> list1 = dto.getReviews();
        if ( list1 != null ) {
            pharmacy.setReviews( new ArrayList<Review>( list1 ) );
        }

        return pharmacy;
    }

    @Override
    public List<PharmacyDto> toPharmacyDtoList(List<Pharmacy> pharmacies) {
        if ( pharmacies == null ) {
            return null;
        }

        List<PharmacyDto> list = new ArrayList<PharmacyDto>( pharmacies.size() );
        for ( Pharmacy pharmacy : pharmacies ) {
            list.add( toDto( pharmacy ) );
        }

        return list;
    }

    @Override
    public List<Pharmacy> toPharmacyList(List<PharmacyDto> Dtos) {
        if ( Dtos == null ) {
            return null;
        }

        List<Pharmacy> list = new ArrayList<Pharmacy>( Dtos.size() );
        for ( PharmacyDto pharmacyDto : Dtos ) {
            list.add( toEntity( pharmacyDto ) );
        }

        return list;
    }
}
