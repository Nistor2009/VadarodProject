package com.example.VadarodProject.service;

import com.example.VadarodProject.dto.RecipeDto;
import com.example.VadarodProject.entity.Recipe;
import com.example.VadarodProject.mapper.RecipeMapper;
import com.example.VadarodProject.repository.RecipeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeMapper recipeMapper;

    public RecipeDto addRecipe(RecipeDto recipe) {
        return recipeMapper.toDto(recipeRepository.save(recipeMapper.toEntity(recipe)));
    }

    public void deleteRecipe(RecipeDto recipe) {
        recipeRepository.delete(recipeMapper.toEntity(recipe));
    }

    public RecipeDto findById(Long id) {
        Optional<Recipe> recipe = recipeRepository.findById(id);
        return recipeMapper.toDto(recipe.orElse(new Recipe()));
    }

    public List<RecipeDto> findAll() {
        return recipeMapper.toRecipeDtoList((List<Recipe>) recipeRepository.findAll());
    }
}
