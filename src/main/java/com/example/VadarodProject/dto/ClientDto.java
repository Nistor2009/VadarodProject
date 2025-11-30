package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Recipe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientDto {
    @JsonIgnore
    private Long id;
    private String name;
    private String surname;
    private int age;
    @JsonProperty("mobile phone")
    private String phone;
    private List<Recipe> recipe;
}
