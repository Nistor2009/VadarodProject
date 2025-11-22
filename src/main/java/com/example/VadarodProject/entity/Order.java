package com.example.VadarodProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "order", schema = "work")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(name = "orderSequence", sequenceName = "s_order", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "orderSequence")
    private Long id;
    private int state;
    @OneToMany
    @ToString.Exclude
    private List<Price> priceList;
    @OneToOne
    private Client client;
}
