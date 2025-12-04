package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Client;
import com.example.VadarodProject.entity.Price;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class OrderDto {
    private Long id;
    private int state;
    private List<Price> priceList;
    @NotNull(message = "Поле 'Клиент' не заполнено")
    private Client client;
}
