package br.dev.celso.receitas.dto;

import br.dev.celso.receitas.model.Category;
import br.dev.celso.receitas.model.Direction;
import br.dev.celso.receitas.model.Ingredient;
import jakarta.persistence.*;

import java.util.List;

public record Recipe2DTO(
        Long id,
        String name,
        String description,
        String imageUrl,
        String cookingTime,
        List<Ingredient> ingredients,
        List<Direction> directions,
        Category category
) {
}
