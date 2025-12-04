package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.OrderDto;
import com.example.VadarodProject.entity.Order;
import com.example.VadarodProject.entity.Price;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-04T20:21:24+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        orderDto.setId( order.getId() );
        orderDto.setState( order.getState() );
        List<Price> list = order.getPriceList();
        if ( list != null ) {
            orderDto.setPriceList( new ArrayList<Price>( list ) );
        }
        orderDto.setClient( order.getClient() );

        return orderDto;
    }

    @Override
    public Order toEntity(OrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        Order order = new Order();

        order.setId( dto.getId() );
        order.setState( dto.getState() );
        List<Price> list = dto.getPriceList();
        if ( list != null ) {
            order.setPriceList( new ArrayList<Price>( list ) );
        }
        order.setClient( dto.getClient() );

        return order;
    }

    @Override
    public List<OrderDto> toOrderDtoList(List<Order> orders) {
        if ( orders == null ) {
            return null;
        }

        List<OrderDto> list = new ArrayList<OrderDto>( orders.size() );
        for ( Order order : orders ) {
            list.add( toDto( order ) );
        }

        return list;
    }

    @Override
    public List<Order> toOrderList(List<OrderDto> Dtos) {
        if ( Dtos == null ) {
            return null;
        }

        List<Order> list = new ArrayList<Order>( Dtos.size() );
        for ( OrderDto orderDto : Dtos ) {
            list.add( toEntity( orderDto ) );
        }

        return list;
    }
}
