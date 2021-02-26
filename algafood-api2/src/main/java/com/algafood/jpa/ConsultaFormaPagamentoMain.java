package com.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApi2Application;
import com.algafood.domain.model.FormaPagamento;
import com.algafood.domain.repository.FormaPagamentoRepository;

public class ConsultaFormaPagamentoMain {

	public static void main(String[] args) {		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		FormaPagamentoRepository formasDePagamento = applicationContext.getBean(FormaPagamentoRepository.class);
		
		List<FormaPagamento> todasFormasDePagamento = formasDePagamento.listar();
		
		for (FormaPagamento formaPagamento: todasFormasDePagamento) {
			System.out.printf("%s  \n",formaPagamento.getDescricao());
		} 
		
		
	}
	
	
}
