package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Cure;
import com.example.VadarodProject.entity.Pharmacy;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PriceDto {
    private Long id;
    @NotNull(message = "Поле 'Препарат' не заполнено")
    private Cure cure;
    @Positive(message = "Стоимость должна быть положительной")
    private double price;
    private Pharmacy pharmacy;
}
