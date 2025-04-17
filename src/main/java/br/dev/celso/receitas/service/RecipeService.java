package br.dev.celso.receitas.service;

import br.dev.celso.receitas.dto.Recipe2DTO;
import br.dev.celso.receitas.model.Direction;
import br.dev.celso.receitas.model.Ingredient;
import br.dev.celso.receitas.model.Recipe;
import br.dev.celso.receitas.repository.RecipeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecipeService {

    @Autowired
    private RecipeRepository recipeRepository;

    public Recipe2DTO save(Recipe2DTO recipe2DTO) {

        System.out.println("recepe2DTO-->" + recipe2DTO.toString());
        Recipe recipe = new Recipe();
        BeanUtils.copyProperties(recipe2DTO, recipe);
        Recipe newRecipe = recipeRepository.save(recipe);
        System.out.println("newRecipe-->" + newRecipe.toString());
        BeanUtils.copyProperties(newRecipe, recipe2DTO);
        System.out.println("recepe2DTO-->" + recipe2DTO.toString());
        return recipe2DTO;
    }

    public List<Recipe2DTO> findAll() {
        return recipeRepository.findAll()
                .stream()
                .map(recipe -> new Recipe2DTO(
                        recipe.getId(),
                        recipe.getName(),
                        recipe.getDescription(),
                        recipe.getImageUrl(),
                        recipe.getCookingTime(),
                        recipe.getIngredients()
                                .stream()
                                .map(ingredient -> new Ingredient(
                                        ingredient.getId(),
                                        ingredient.getName()
                                )).toList(),
                        recipe.getDirections()
                                .stream()
                                .map(direction -> new Direction(
                                        direction.getId(),
                                        direction.getDirection(),
                                        direction.getDescription()
                                )).toList(),
                        recipe.getCategory()
                )).toList();
    }

    public Recipe2DTO findById(Long id) {
        Optional<Recipe2DTO> recipe2DTO = recipeRepository.findById(id)
                .map(recipe -> new Recipe2DTO(
                        recipe.getId(),
                        recipe.getName(),
                        recipe.getDescription(),
                        recipe.getImageUrl(),
                        recipe.getCookingTime(),
                        recipe.getIngredients()
                                .stream()
                                .map(ingredient -> new Ingredient(
                                        ingredient.getId(),
                                        ingredient.getName()
                                )).toList(),
                        recipe.getDirections()
                                .stream()
                                .map(direction -> new Direction(
                                        direction.getId(),
                                        direction.getDirection(),
                                        direction.getDescription()
                                )).toList(),
                        recipe.getCategory()
                ));
        return recipe2DTO.orElse(null);
    }



}
