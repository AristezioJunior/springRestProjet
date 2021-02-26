package com.algafood.domain.model;

import javax.persistence.Column;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.EqualsAndHashCode;

//@Getter
//@Setter
//@EqualsAndHashCode
@Data // All together now: A shortcut for @ToString, @EqualsAndHashCode, @Getter on all fields, and @Setter on all non-final fields, and @RequiredArgsConstructor!
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity //Representa uma entidade do modela da tabela 
//@Table(name= "tab_cozinhas")  //caso queira mudar o nome da tabela pois ao criar ela vai ser o nome da classe
public class Cozinha {

	@EqualsAndHashCode.Include //dando referencia para só o id ter equals e HashCode
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable= false)  //O sistema entende que o atributo vai ser uma coluna
	private String nome;

	
	
	
	
}
