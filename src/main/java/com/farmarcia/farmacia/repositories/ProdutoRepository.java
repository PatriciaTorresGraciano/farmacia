package com.farmarcia.farmacia.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.farmarcia.farmacia.models.ProdutoModel;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long>{

	Optional<List<ProdutoModel>>findByDescricaoProdutoContainingIgnoringCase(String descricaoProduto);
}
