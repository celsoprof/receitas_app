package br.dev.celso.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import br.dev.celso.receitas.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
