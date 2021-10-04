package com.farmarcia.farmacia.controllers;

import java.util.List;

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
import com.farmarcia.farmacia.models.ProdutoModel;
import com.farmarcia.farmacia.repositories.ProdutoRepository;

@RestController
@RequestMapping("/farmacia/produtos")
@CrossOrigin("*")
public class ProdutoController {

	@Autowired
	private ProdutoRepository repositoryProduto;
	
	@GetMapping("/all")
	public ResponseEntity<List<ProdutoModel>> getAll(){
		return ResponseEntity.ok(repositoryProduto.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoModel> getId(@PathVariable long id){
		return repositoryProduto.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/descriptions/{description}")
	public ResponseEntity<List<ProdutoModel>> getDescription(@PathVariable String description){
		return repositoryProduto.findByDescricaoProdutoContainingIgnoringCase(description)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());		
	}
	
	@PostMapping
	public ResponseEntity<ProdutoModel> postCategoria(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoryProduto.save(produto));
	}
	
	@PutMapping
	public ResponseEntity<ProdutoModel> putCategoria(@RequestBody ProdutoModel produto){
		return ResponseEntity.status(HttpStatus.OK).body(repositoryProduto.save(produto));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repositoryProduto.deleteById(id);
	}
	
	
}
