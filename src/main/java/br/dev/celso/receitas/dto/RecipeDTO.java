package br.dev.celso.receitas.dto;

import br.dev.celso.receitas.model.Direction;
import br.dev.celso.receitas.model.Ingredient;
import br.dev.celso.receitas.model.Recipe;

import java.util.List;

public class RecipeDTO {

    private Long id;

    private String name;
    private String description;
    private String imageUrl;
    private String cookingTime;
    private List<Ingredient> ingredients;
    private List<Direction> directions;

    private Long categoryId;
    private String categoryName;
    private String categoryImageUrl;

    public RecipeDTO(Recipe recipe) {
        this.id = recipe.getId();
        this.name = recipe.getName();
        this.description = recipe.getDescription();
        this.imageUrl = recipe.getImageUrl();
        this.cookingTime = recipe.getCookingTime();
        this.ingredients = recipe.getIngredients();
        this.directions = recipe.getDirections();
        if (recipe.getCategory() != null){
            this.categoryId = recipe.getCategory().getId();
            this.categoryName = recipe.getCategory().getName();
            this.categoryImageUrl = recipe.getCategory().getImageUrl();
        }
    }

    public RecipeDTO(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(String cookingTime) {
        this.cookingTime = cookingTime;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public List<Direction> getDirections() {
        return directions;
    }

    public void setDirections(List<Direction> directions) {
        this.directions = directions;
    }

}
