package com.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApi2Application;
import com.algafood.domain.model.Estado;
import com.algafood.domain.repository.EstadoRepository;

public class ConsultaEstadoMain {

	public static void main(String[] args) {		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		EstadoRepository estados = applicationContext.getBean(EstadoRepository.class);
		
		List<Estado> todosEstados = estados.listar();
		
		for (Estado estado: todosEstados) {
			System.out.printf("%s \n",estado.getNome());
		} 
		
		
	}
	
	
}
