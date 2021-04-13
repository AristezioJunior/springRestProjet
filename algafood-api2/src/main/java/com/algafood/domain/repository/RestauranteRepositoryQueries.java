package com.algafood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	//Aula 5.11
	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> findComFreteGratis(String nome);
	
}