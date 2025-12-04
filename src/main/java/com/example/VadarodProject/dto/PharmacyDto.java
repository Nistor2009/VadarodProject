package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Address;
import com.example.VadarodProject.entity.Price;
import com.example.VadarodProject.entity.Review;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class PharmacyDto {
    private Long id;
    @NotBlank(message = "Поле 'Наименование' не заполнено")
    private String name;
    private List<Price> prices;
    private Address address;
    private List<Review> reviews;
}
