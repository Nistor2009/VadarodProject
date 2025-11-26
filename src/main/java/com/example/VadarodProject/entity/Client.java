package com.example.VadarodProject.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "client", schema = "work")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @SequenceGenerator(name = "clientSequence", sequenceName = "s_client", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "clientSequence")
    private Long id;
    private String name;
    private String surname;
    private int age;
    private String phone;
    @OneToMany
    @ToString.Exclude
    private List<Recipe> recipe;
}
