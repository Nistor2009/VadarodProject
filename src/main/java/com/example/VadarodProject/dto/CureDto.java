package com.example.VadarodProject.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CureDto {
    private Long id;
    @NotBlank(message = "Поле 'Наименование' не заполнено")
    private String name;
    private boolean isNeedRecipe;
}
