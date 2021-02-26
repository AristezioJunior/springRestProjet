package com.algafood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.algafood.AlgafoodApi2Application;
import com.algafood.domain.model.Permissao;
import com.algafood.domain.repository.PermissaoRepository;

public class AlteracaoPermissaoMain {

	public static void main(String[] args) {		
		ApplicationContext applicationContext = new SpringApplicationBuilder(AlgafoodApi2Application.class)
				.web(WebApplicationType.NONE)
				.run(args);
		
		PermissaoRepository permissaoRepository = applicationContext.getBean(PermissaoRepository.class);
		
		Permissao permissao = new Permissao();
		permissao.setId(1L);
		permissao.setNome("consultar_cozinhas");
		permissao.setDescricao("permite consultar cozinhas");
				
		
		permissaoRepository.salvar(permissao);
		
		
		
	}
	
	
}
