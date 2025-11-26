package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.DeliveryMan;
import com.example.VadarodProject.entity.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class DeliveryDto {
    private Long id;
    private String name;
    private List<DeliveryMan> deliveryManList;
    private List<Review> reviews;
}
