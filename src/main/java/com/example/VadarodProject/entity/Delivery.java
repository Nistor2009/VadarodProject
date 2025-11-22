package com.example.VadarodProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "delivery", schema = "work")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Delivery {
    @Id
    @SequenceGenerator(name = "deliverySequence", sequenceName = "s_delivery", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deliverySequence")
    private Long id;
    private String name;
    @OneToMany
    @ToString.Exclude
    private List<DeliveryMan> deliveryManList;
    @OneToMany
    @ToString.Exclude
    private List<Review> reviews;

}
