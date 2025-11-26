package com.example.VadarodProject.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CureDto {
    private Long id;
    private String name;
    private boolean isNeedRecipe;
}
