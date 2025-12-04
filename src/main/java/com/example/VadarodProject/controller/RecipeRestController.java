package com.example.VadarodProject.controller;

import com.example.VadarodProject.dto.RecipeDto;
import com.example.VadarodProject.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/recipe")
public class RecipeRestController {
    private final RecipeService recipeService;

    @GetMapping("/find")
    public ResponseEntity<RecipeDto> getRecipeByParam(@RequestParam("id") Long id) {
        RecipeDto recipeDto = recipeService.findById(id);
        return new ResponseEntity<>(recipeDto, HttpStatus.OK);
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<RecipeDto>> getAllRecipe(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sort,
            @RequestParam(defaultValue = "asc") String direction) {
        Sort.Direction sortDirection;
        if (Objects.equals(direction, "asc")) {
            sortDirection = Sort.Direction.ASC;
        } else sortDirection = Sort.Direction.DESC;
        List<RecipeDto> recipeDto = recipeService.findAll(page, size, sort, sortDirection);
        return new ResponseEntity<>(recipeDto, HttpStatus.OK);
    }

    @PostMapping("/add")
    public RecipeDto addRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.addRecipe(recipeDto);
    }

    @PostMapping("/delete")
    public RecipeDto deleteRecipe(@RequestBody RecipeDto recipeDto) {
        return recipeService.deleteRecipe(recipeDto);
    }
}
