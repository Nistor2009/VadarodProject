package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Recipe;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
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
    @NotBlank(message = "Поле 'Имя' не заполнено")
    private String name;
    @NotBlank(message = "Поле 'Фамилия' не заполнено")
    private String surname;
    private int age;
    @JsonProperty("mobile phone")
    private String phone;
    private List<Recipe> recipe;
}
