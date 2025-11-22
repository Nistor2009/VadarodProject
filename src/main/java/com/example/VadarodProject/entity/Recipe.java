package com.example.VadarodProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "recipe", schema = "work")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Recipe {
    @Id
    @SequenceGenerator(name = "recipeSequence", sequenceName = "s_recipe", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "recipeSequence")
    private Long id;
    private String description;
    @OneToOne
    private Cure cure;
}
