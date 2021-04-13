package com.algafood.jpa;

//import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.algafood.AlgafoodApi2Application;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;

public class BuscaCozinhaMain {

	public static void main(String[] args) {		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		
		Cozinha cozinha = cozinhaRepository.findById(1L).orElse(null);
		
		
			System.out.println(cozinha.getNome());
		 
		
		
	}
	
	
}
