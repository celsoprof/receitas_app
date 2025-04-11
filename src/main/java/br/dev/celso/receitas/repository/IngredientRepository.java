package br.dev.celso.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.celso.receitas.model.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, Long> {

}
