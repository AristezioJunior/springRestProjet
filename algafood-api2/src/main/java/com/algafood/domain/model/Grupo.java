package com.algafood.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Grupo {
	
	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@JsonIgnore //faz com que a forma de pagamento não saia na pesquisa do postman
	@ManyToMany
	//Customizando a tabela auxiliar 
	@JoinTable(name = "grupo_permissao", joinColumns = @JoinColumn (name="grupo_id"),
	inverseJoinColumns = @JoinColumn (name = "permissao_id"))
	private List<Permissao> permissoes = new ArrayList<>();
	
}
