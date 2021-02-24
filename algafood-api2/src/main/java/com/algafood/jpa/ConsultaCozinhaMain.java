package com.algafood.jpa;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algafood.AlgafoodApi2Application;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;

public class ConsultaCozinhaMain {

	public static void main(String[] args) {		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhas = applicationContext.getBean(CozinhaRepository.class);
		
		List<Cozinha> todasCozinhas = cozinhas.todas();
		
		for (Cozinha cozinha: todasCozinhas) {
			System.out.println(cozinha.getNome());
		} 
		
		
	}
	
	
}
