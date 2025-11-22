package com.example.VadarodProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "price", schema = "work")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Price {
    @Id
    @SequenceGenerator(name = "priceSequence", sequenceName = "s_price", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "priceSequence")
    private Long id;
    @OneToOne
    private Cure cure;
    private double price;
    @ManyToOne
    private Pharmacy pharmacy;

}
