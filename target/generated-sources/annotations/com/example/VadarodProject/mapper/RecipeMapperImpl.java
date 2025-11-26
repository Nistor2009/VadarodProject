package com.example.VadarodProject.mapper;

import com.example.VadarodProject.dto.RecipeDto;
import com.example.VadarodProject.entity.Recipe;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-26T21:08:10+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.1 (Oracle Corporation)"
)
@Component
public class RecipeMapperImpl implements RecipeMapper {

    @Override
    public RecipeDto toDto(Recipe recipe) {
        if ( recipe == null ) {
            return null;
        }

        RecipeDto recipeDto = new RecipeDto();

        recipeDto.setId( recipe.getId() );
        recipeDto.setDescription( recipe.getDescription() );
        recipeDto.setCure( recipe.getCure() );

        return recipeDto;
    }

    @Override
    public Recipe toEntity(RecipeDto dto) {
        if ( dto == null ) {
            return null;
        }

        Recipe recipe = new Recipe();

        recipe.setId( dto.getId() );
        recipe.setDescription( dto.getDescription() );
        recipe.setCure( dto.getCure() );

        return recipe;
    }

    @Override
    public List<RecipeDto> toRecipeDtoList(List<Recipe> recipes) {
        if ( recipes == null ) {
            return null;
        }

        List<RecipeDto> list = new ArrayList<RecipeDto>( recipes.size() );
        for ( Recipe recipe : recipes ) {
            list.add( toDto( recipe ) );
        }

        return list;
    }

    @Override
    public List<Recipe> toRecipeList(List<RecipeDto> recipes) {
        if ( recipes == null ) {
            return null;
        }

        List<Recipe> list = new ArrayList<Recipe>( recipes.size() );
        for ( RecipeDto recipeDto : recipes ) {
            list.add( toEntity( recipeDto ) );
        }

        return list;
    }
}
