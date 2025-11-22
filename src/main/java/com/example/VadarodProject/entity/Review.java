package com.example.VadarodProject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "review", schema = "work")
@ToString
@Getter
@Setter
@NoArgsConstructor
public class Review {
    @Id
    @SequenceGenerator(name = "reviewSequence", sequenceName = "s_review", allocationSize = 1, schema = "work")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "reviewSequence")
    private Long id;
    private String clientName;
    private String description;
    private int mark;
}
