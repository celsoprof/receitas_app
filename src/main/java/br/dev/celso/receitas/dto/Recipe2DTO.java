package br.dev.celso.receitas.dto;

import br.dev.celso.receitas.model.Category;
import br.dev.celso.receitas.model.Direction;
import br.dev.celso.receitas.model.Ingredient;

import java.util.List;

public class Recipe2DTO {
    Long id;
    String name;
    String description;
    String imageUrl;
    String cookingTime;
    List<Ingredient> ingredients;
    List<Direction> directions;
    Category category;

    public Recipe2DTO(Long id, String name, String description, String imageUrl, String cookingTime, List<Ingredient> ingredients, List<Direction> directions, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.directions = directions;
        this.category = category;
    }

    public Recipe2DTO() {}

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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
