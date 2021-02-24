package com.algafood.jpa;

import java.math.BigDecimal;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApi2Application;
import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;



public class InclusaoRestauranteMain {

	public static void main(String[] args) {		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		RestauranteRepository restauranteReposytory = applicationContext.getBean(RestauranteRepository.class);
		
		Restaurante restaurante1 = new Restaurante();
		restaurante1.setNome("A cabana");
		restaurante1.setTaxaFrete(new BigDecimal("6.00"));
		
		Restaurante restaurante2 = new Restaurante();
		restaurante2.setNome("MedievalMenta");
		restaurante2.setTaxaFrete(new BigDecimal("10.00"));
		
		restaurante1 = restauranteReposytory.salvar(restaurante1);
		restaurante2 = restauranteReposytory.salvar(restaurante2);
		
		System.out.printf("Id: %d -- Nome:   %s-- Taxa Entrega: %f\n", restaurante1.getId(), restaurante1.getNome(), restaurante1.getTaxaFrete());
		System.out.printf("Id: %d -- Nome:   %s-- Taxa Entrega: %f\n", restaurante2.getId(), restaurante2.getNome(), restaurante2.getTaxaFrete());
		
		
		
	}
	
	
}
