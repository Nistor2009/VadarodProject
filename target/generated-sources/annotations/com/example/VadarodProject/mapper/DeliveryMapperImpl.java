package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.DeliveryDto;
import com.example.VadarodProject.entity.Delivery;
import com.example.VadarodProject.entity.DeliveryMan;
import com.example.VadarodProject.entity.Review;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T21:08:09+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class DeliveryMapperImpl implements DeliveryMapper {

    @Override
    public DeliveryDto toDto(Delivery delivery) {
        if ( delivery == null ) {
            return null;
        }

        DeliveryDto deliveryDto = new DeliveryDto();

        deliveryDto.setId( delivery.getId() );
        deliveryDto.setName( delivery.getName() );
        List<DeliveryMan> list = delivery.getDeliveryManList();
        if ( list != null ) {
            deliveryDto.setDeliveryManList( new ArrayList<DeliveryMan>( list ) );
        }
        List<Review> list1 = delivery.getReviews();
        if ( list1 != null ) {
            deliveryDto.setReviews( new ArrayList<Review>( list1 ) );
        }

        return deliveryDto;
    }

    @Override
    public Delivery toEntity(DeliveryDto dto) {
        if ( dto == null ) {
            return null;
        }

        Delivery delivery = new Delivery();

        delivery.setId( dto.getId() );
        delivery.setName( dto.getName() );
        List<DeliveryMan> list = dto.getDeliveryManList();
        if ( list != null ) {
            delivery.setDeliveryManList( new ArrayList<DeliveryMan>( list ) );
        }
        List<Review> list1 = dto.getReviews();
        if ( list1 != null ) {
            delivery.setReviews( new ArrayList<Review>( list1 ) );
        }

        return delivery;
    }

    @Override
    public List<DeliveryDto> toDeliveryDtoList(List<Delivery> deliveries) {
        if ( deliveries == null ) {
            return null;
        }

        List<DeliveryDto> list = new ArrayList<DeliveryDto>( deliveries.size() );
        for ( Delivery delivery : deliveries ) {
            list.add( toDto( delivery ) );
        }

        return list;
    }

    @Override
    public List<Delivery> toDeliveryList(List<DeliveryDto> Dtos) {
        if ( Dtos == null ) {
            return null;
        }

        List<Delivery> list = new ArrayList<Delivery>( Dtos.size() );
        for ( DeliveryDto deliveryDto : Dtos ) {
            list.add( toEntity( deliveryDto ) );
        }

        return list;
    }
}
