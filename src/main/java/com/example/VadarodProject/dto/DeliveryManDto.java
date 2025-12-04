package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Order;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryManDto {
    private Long id;
    @NotBlank(message = "Поле 'Имя' не заполнено")
    private String name;
    @NotBlank(message = "Поле 'Фамилия' не заполнено")
    private String surname;
    private String phone;
    private List<Order> orderList;
}
