package com.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApi2Application;
import com.algafood.domain.model.Cidade;
import com.algafood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

	public static void main(String[] args) {		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		CidadeRepository cidades = applicationContext.getBean(CidadeRepository.class);
		
		List<Cidade> todasCidades = cidades.findAll();	
		for (Cidade cidade: todasCidades) {
			System.out.printf("%s - %s\n",cidade.getNome(),cidade.getEstado().getNome());
		} 
		
		
	}
	
}
