package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Recipe;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ClientRequest {
    private Long id;
    @NotBlank(message = "Поле 'Имя' не заполнено")
    private String name;
    @NotBlank(message = "Поле 'Фамилия' не заполнено")
    private String surname;
    private int age;
    private String phone;
    private List<Recipe> recipe;
}
