package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.DeliveryManDto;
import com.example.VadarodProject.entity.DeliveryMan;
import com.example.VadarodProject.entity.Order;
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
public class DeliveryManMapperImpl implements DeliveryManMapper {

    @Override
    public DeliveryManDto toDto(DeliveryMan deliveryMan) {
        if ( deliveryMan == null ) {
            return null;
        }

        DeliveryManDto deliveryManDto = new DeliveryManDto();

        deliveryManDto.setId( deliveryMan.getId() );
        deliveryManDto.setName( deliveryMan.getName() );
        deliveryManDto.setSurname( deliveryMan.getSurname() );
        deliveryManDto.setPhone( deliveryMan.getPhone() );
        List<Order> list = deliveryMan.getOrderList();
        if ( list != null ) {
            deliveryManDto.setOrderList( new ArrayList<Order>( list ) );
        }

        return deliveryManDto;
    }

    @Override
    public DeliveryMan toEntity(DeliveryManDto dto) {
        if ( dto == null ) {
            return null;
        }

        DeliveryMan deliveryMan = new DeliveryMan();

        deliveryMan.setId( dto.getId() );
        deliveryMan.setName( dto.getName() );
        deliveryMan.setSurname( dto.getSurname() );
        deliveryMan.setPhone( dto.getPhone() );
        List<Order> list = dto.getOrderList();
        if ( list != null ) {
            deliveryMan.setOrderList( new ArrayList<Order>( list ) );
        }

        return deliveryMan;
    }

    @Override
    public List<DeliveryManDto> toDeliveryManDtoList(List<DeliveryMan> deliveryMEN) {
        if ( deliveryMEN == null ) {
            return null;
        }

        List<DeliveryManDto> list = new ArrayList<DeliveryManDto>( deliveryMEN.size() );
        for ( DeliveryMan deliveryMan : deliveryMEN ) {
            list.add( toDto( deliveryMan ) );
        }

        return list;
    }

    @Override
    public List<DeliveryMan> toDeliveryManList(List<DeliveryManDto> Dtos) {
        if ( Dtos == null ) {
            return null;
        }

        List<DeliveryMan> list = new ArrayList<DeliveryMan>( Dtos.size() );
        for ( DeliveryManDto deliveryManDto : Dtos ) {
            list.add( toEntity( deliveryManDto ) );
        }

        return list;
    }
}
