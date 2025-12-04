package com.example.VadarodProject.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ReviewDto {
    private Long id;
    @NotBlank(message = "Поле 'Имя' не заполнено")
    private String clientName;
    @NotNull
    private String description;
    @NotNull(message = "Оценка не выставлена")
    private int mark;
}
