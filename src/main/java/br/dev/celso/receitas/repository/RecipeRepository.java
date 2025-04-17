package br.dev.celso.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.dev.celso.receitas.model.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {

}
