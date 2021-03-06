package com.algafood.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Getter
//@Setter
//@EqualsAndHashCode

//@JsonRootName("Gastronomia")// Muda o nome do objeto quando requisitado no xml
@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity //Representa uma entidade do modela da tabela 
//@Table(name= "tab_cozinhas")  //caso queira mudar o nome da tabela pois ao criar ela vai ser o nome da classe
public class Cozinha {

	@EqualsAndHashCode.Include //dando referencia para só o id ter equals e HashCode
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	//@JsonIgnore
	//@JsonProperty("titulo")
	@Column(nullable= false)  //O sistema entende que o atributo vai ser uma coluna
	private String nome;

	@JsonIgnore //Como nesse caso cozinha iria chamar restaurante e restaurante iria chamar cozinha, virando um loop infinity, usamos essa anotação para ignorar esse atributo
	@OneToMany(mappedBy= "cozinha") //pega do atributo que esta sendo mapeado
	private List<Restaurante> restaurantes = new ArrayList<>();
	
	
}
