package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.RecipeDto;
import com.example.VadarodProject.entity.Recipe;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RecipeMapper {
    @Mapping(target = "id")
    RecipeDto toDto(Recipe recipe);

    @Mapping(target = "id")
    Recipe toEntity(RecipeDto dto);

    List<RecipeDto> toRecipeDtoList(List<Recipe> recipes);
    List<Recipe> toRecipeList(List<RecipeDto> recipes);



}
