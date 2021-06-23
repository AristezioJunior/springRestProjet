
package com.algafood.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String nome;
	
	@Column(name="taxa_frete", nullable= false)
	private BigDecimal taxaFrete;

	//@JsonIgnore
	@JsonIgnoreProperties("hibernateLazyInitializer") //Aula 6.12 Fetching para Lazy
	@ManyToOne(fetch= FetchType.LAZY)//Só carrega se precisar (como estamos usando o JsonIgnore ele não faz mas o select cozinha)
	@JoinColumn(name = "cozinha_id", nullable = false) //Esse nome do id tem que ser o mesmo que vai ser utilizado no import.sql
	private Cozinha cozinha;	
	
	//Aula6.4
	@JsonIgnore
	@Embedded
	private Endereco endereco;
	
	@JsonIgnore
	@CreationTimestamp //anotação da implementação do hibernate, quando uma entidade é criada a hora atual é salva
	@Column(nullable = false, columnDefinition = "datetime") //informa que não pode ser null / ColumnDefinition vai padronizar a data e hora
	private LocalDateTime dataCadastro;
	
	@JsonIgnore
	@UpdateTimestamp
	@Column(nullable = false, columnDefinition = "datetime")//informa que não pode ser null
	private LocalDateTime dataAtualizacao;
		
	
	//@JsonIgnore //faz com que a forma de pagamento não saia na pesquisa do postman
	@ManyToMany						//(fetch = FetchType.EAGER)//Dificilmente usa o eager pois ele carrega toda vida o select
	//Customizando a tabela auxiliar 
	@JoinTable(name = "restaurante_forma_pagamento", joinColumns = @JoinColumn (name="restaurante_id"),
	inverseJoinColumns = @JoinColumn (name = "forma_pagamento_id"))
	private List<FormaPagamento> formasPagamento = new ArrayList<>();
	
	@JsonIgnore //faz com que a forma de pagamento não saia na pesquisa do postman
	@OneToMany(mappedBy = "restaurante")
	private List<Produto> produtos = new ArrayList<>();
}
