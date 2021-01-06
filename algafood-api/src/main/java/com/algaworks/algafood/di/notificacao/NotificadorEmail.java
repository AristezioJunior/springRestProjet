package com.algaworks.algafood.di.notificacao;

import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

//Bean Spring
@Component
public class NotificadorEmail implements Notificador {
	
	private boolean caixaAlta;
	
	public NotificadorEmail() {
		
		System.out.println("Construtor da classe NotificadorEmail Chamado. O @Component gerencia os Beans.");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		if(this.caixaAlta) {
			mensagem = mensagem.toUpperCase();
		}
		System.out.printf("Notificando %s através do e-mail %s: %s\n",
				cliente.getNome(), cliente.getEmail(), mensagem);
		
	}
	
}
