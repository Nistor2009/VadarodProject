package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Cure;
import com.example.VadarodProject.entity.Pharmacy;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PriceDto {
    private Long id;
    private Cure cure;
    private double price;
    private Pharmacy pharmacy;
}
