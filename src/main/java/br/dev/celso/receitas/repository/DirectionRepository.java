package br.dev.celso.receitas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.celso.receitas.model.Direction;

public interface DirectionRepository extends JpaRepository<Direction, Long>{

}
