package br.dev.celso.receitas.dto;

import br.dev.celso.receitas.model.Ingredient;
import org.springframework.beans.BeanUtils;

public class IngredientDTO {

    private Long id;
    private String name;

    public IngredientDTO(){}

    public IngredientDTO(Ingredient ingredient) {
        BeanUtils.copyProperties(ingredient, this);
    }

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

}
