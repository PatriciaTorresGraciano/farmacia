package com.farmarcia.farmacia.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmarcia.farmacia.models.CategoriaModel;
import com.farmarcia.farmacia.repositories.CategoriaRepository;

@RestController
@RequestMapping("/farmacia/categorias")
@CrossOrigin("*")
public class CategoriaController {

	@Autowired
	private CategoriaRepository repositoryCategoria;
	
	@GetMapping("/all")
	public ResponseEntity<List<CategoriaModel>> getAllCategoria(){
		return ResponseEntity.ok(repositoryCategoria.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CategoriaModel> getId(@PathVariable long id){
		return repositoryCategoria.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descriptions/{description}")
	public ResponseEntity<List<CategoriaModel>> getDescription(@PathVariable String description){
		return repositoryCategoria.findByDescricaoCategoriaContainingIgnoreCase(description)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@PostMapping
	public ResponseEntity<CategoriaModel> postCategoria(@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryCategoria.save(categoria));
	}
	
	@PutMapping
	public ResponseEntity<CategoriaModel> putCategoria(@Valid @RequestBody CategoriaModel categoria){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryCategoria.save(categoria));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoryCategoria.deleteById(id);
	}
	
}
