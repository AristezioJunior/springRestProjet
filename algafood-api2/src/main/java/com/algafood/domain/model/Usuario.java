package com.algafood.domain.model;

import java.time.LocalDateTime;
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

import org.hibernate.annotations.CreationTimestamp;


import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@CreationTimestamp //anotação da implementação do hibernate, quando uma entidade é criada a hora atual é salva
	@Column(nullable = false, columnDefinition = "datetime") //informa que não pode ser null / ColumnDefinition vai padronizar a data e hora
	private LocalDateTime dataCadastro;
	
	@ManyToMany
	//Customizando a tabela auxiliar 
	@JoinTable(name = "usuario_grupo", joinColumns = @JoinColumn (name="usuario_id"),
	inverseJoinColumns = @JoinColumn (name = "grupo_id"))
	private List<Grupo> grupos = new ArrayList<>();
	
	
	
}
