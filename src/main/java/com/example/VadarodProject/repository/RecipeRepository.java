package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Recipe;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository  extends CrudRepository<Recipe, Long> {
}
