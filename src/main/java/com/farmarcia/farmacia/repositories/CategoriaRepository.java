package com.farmarcia.farmacia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmarcia.farmacia.models.CategoriaModel;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long>{

	Optional <List<CategoriaModel>>findByDescricaoCategoriaContainingIgnoreCase(String descricao);
	
}
