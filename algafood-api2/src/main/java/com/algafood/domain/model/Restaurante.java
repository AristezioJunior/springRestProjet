package com.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	@Column(name="taxa_frete")
	private BigDecimal taxaFrete;

	@ManyToOne
	//@JoinColumn(name = "cozinha_codigo") //Esse nome do id tem que ser o mesmo que vai ser utilizado no import.sql
	private Cozinha cozinha;	
	
	
	
	
}
