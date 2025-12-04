package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Cure;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto {
    private Long id;
    @NotBlank(message = "Добавьте способ применений")
    private String description;
    @NotNull(message = "Поле 'Препарат' не заполнено")
    private Cure cure;
}
