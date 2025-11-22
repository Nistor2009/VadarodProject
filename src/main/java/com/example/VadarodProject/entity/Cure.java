package com.example.VadarodProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "cure", schema = "work")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Cure {
    @Id
    @SequenceGenerator(name = "cureSequence", sequenceName = "s_cure", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cureSequence")
    private Long id;
    private String name;
    private boolean isNeedRecipe;
}
