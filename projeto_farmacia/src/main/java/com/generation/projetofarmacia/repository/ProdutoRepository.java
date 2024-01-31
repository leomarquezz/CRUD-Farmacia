package com.generation.projetofarmacia.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.generation.projetofarmacia.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	public List <Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);

	public List <Produto> findAllByDescricaoContainingIgnoreCase(@Param("%descricao%") String descricao);
	
	@Query("SELECT p FROM Produto p WHERE p.preco BETWEEN :minPreco AND :maxPreco")
	List<Produto> findAllByPrecoBetween(@Param("minPreco") BigDecimal minPreco, @Param("maxPreco") BigDecimal maxPreco);
}