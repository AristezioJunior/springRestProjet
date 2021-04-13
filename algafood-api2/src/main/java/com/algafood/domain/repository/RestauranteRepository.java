package com.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.algafood.domain.model.Restaurante;

public interface RestauranteRepository extends/*AULA 5.20=>*/ CustomJpaRepository<Restaurante, Long>  /*JpaRepository<Restaurante, Long>*/, RestauranteRepositoryQueries, JpaSpecificationExecutor<Restaurante> {

	//Acrescentando mais métodos para o repositório
	
	//Spring assinaturas de métodos
	//buscando restaurante pela taxa frete
	// Esse método recebe dois valores	e mostra entre o valores escolhidos
	List<Restaurante> findByTaxaFreteBetween(BigDecimal taxaInicial, BigDecimal taxaFinal);
	
	//Acrescentando metodo de busca por restaurante com keywords de like %% mais AND com referencia escolhida
	//Containing = Like / AND = and	
	//List<Restaurante> findByNomeContainingAndCozinhaId(String nome, Long cozinha);
	
	//Criando Query com anotação @Query ou criando no orm.xml para querys maiores.
	//Fazendo o mesmo método findByNomeContainingAndCozinhaId anotando o método com @Query 
	//@Query("from Restaurante where nome like %:nome% and cozinha.id = :id")
	List<Restaurante> ConsultarPorNome(String nome, @Param("id") Long cozinha);	
	//Externalizar as consultas em xml para não poluir o código onde no named-query salvo o name com o nome do método
	
	
	
	//usando flag Fist para indicar a primeira ação (no caso o primeiro restaurante)
	Optional<Restaurante> findFirstRestauranteByNomeContaining(String nome);
	
	//Pegando os primeiros 2 restaurantes
	List<Restaurante> findTop2ByNomeContaining(String nome);
	
	//contando os restaurantes
	int countByCozinhaId(Long Cozinha);
	
	
	
	
	
}


