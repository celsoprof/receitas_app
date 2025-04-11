package br.dev.celso.receitas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.dev.celso.receitas.model.Recipe;
import br.dev.celso.receitas.repository.RecipeRepository;

@RestController
@RequestMapping("/recipes")
public class RecipeController {

	@Autowired
	private RecipeRepository recipeRepository;
	
	@PostMapping
	public ResponseEntity<Recipe> save(@RequestBody Recipe recipe) {
		
		System.out.println("Recipe save called...");
		Recipe recipeOut = recipeRepository.save(recipe);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(recipeOut);
		
	}
	
	@GetMapping
	public ResponseEntity<List<Recipe>> getAll(){
		List<Recipe> recipes = recipeRepository.findAll();
		return ResponseEntity.status(HttpStatus.OK).body(recipes);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Recipe> findById(@PathVariable Long id){
		Recipe recipe = recipeRepository.findById(id).get();
		return ResponseEntity.status(HttpStatus.OK).body(recipe);
	}
	
}
