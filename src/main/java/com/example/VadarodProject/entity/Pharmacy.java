package com.example.VadarodProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "pharmacy", schema = "work")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Pharmacy {
    @Id
    @SequenceGenerator(name = "pharmacySequence", sequenceName = "s_pharmacy", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pharmacySequence")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "pharmacy")
    @ToString.Exclude
    private List<Price> prices;
    @Embedded
    @ToString.Exclude
    private Address address;
    @OneToMany
    @ToString.Exclude
    private List<Review> reviews;
}
