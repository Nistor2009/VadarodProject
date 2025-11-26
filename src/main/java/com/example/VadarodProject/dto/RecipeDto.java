package com.example.VadarodProject.dto;

import com.example.VadarodProject.entity.Cure;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecipeDto {
    private Long id;
    private String description;
    private Cure cure;
}
