package com.example.VadarodProject.repository;

import com.example.VadarodProject.entity.Recipe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository  extends CrudRepository<Recipe, Long> {
    Page<Recipe> findAll(Pageable pageable);
}
