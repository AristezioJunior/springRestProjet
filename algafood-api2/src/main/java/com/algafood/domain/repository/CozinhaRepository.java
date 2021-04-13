package com.algafood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.algafood.domain.model.Cozinha;

@Repository
public interface CozinhaRepository extends JpaRepository<Cozinha, Long>{

	//Implementando um método para listar por nome
	//melhorando essa pesquisa do nome usando uma keywords associada ao like deixando os %%
	List<Cozinha> findTodasByNomeContaining (String nome);
	
	Optional<Cozinha> findByNome(String nome);
	
	//Pesquisa para saber se o nome da pesquisa existe (nome exato como esta no banco) keywords  = exists
	boolean existsByNome(String nome);
}
