package com.algafood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApi2Application;
import com.algafood.domain.model.Permissao;
import com.algafood.domain.repository.PermissaoRepository;

public class ConsultaPermissaoMain {

	public static void main(String[] args) {		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissoes = applicationContext.getBean(PermissaoRepository.class);
		
		List<Permissao> todasPermissoes = permissoes.listar();
		
		for (Permissao permissao: todasPermissoes) {
			System.out.printf("%s - %s \n",permissao.getNome(),permissao.getDescricao());
		} 
		
		
	}
	
}
