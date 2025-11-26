package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryManDto {
    private Long id;
    private String name;
    private String surname;
    private String phone;
    private List<Order> orderList;
}
