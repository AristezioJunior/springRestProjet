package com.algaworks.algafood.di.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.Notificador;

@Component
public class AtivacaoClienteService {

	//@Autowired com (required = false) deixa a independencia não obrigatória
	@Autowired(required = false)
	private Notificador notificador;	
	
	//Anotação Autowired define qual construtor vai ser instanciado pelo Spring
//	@Autowired
//	public AtivacaoClienteService(Notificador notificador) {
//		this.notificador = notificador;
//	
//	System.out.println("AtivacaoClienteService " + notificador);
//	}
	
//	public AtivacaoClienteService(String exemplo) {
//		
//	}
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		if(notificador != null) {
			notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
		}else {
			System.out.println("Não existe notificador. Mas cliente foi ativado.");
		}
	}

//	@Autowired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
	
	
	
}
