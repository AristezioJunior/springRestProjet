package com.algaworks.algafood.di.notificacao;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Profile("dev")
@TipoDoNotificador(NivelUrgencia.NORMAL)
@Component
public class NotificadorEmailMock implements Notificador {
	
	//Construtor da aula 2.20
		public NotificadorEmailMock() {
			System.out.println("Notificador Email MOCK");
		}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
//		if(this.caixaAlta) {
//			mensagem = mensagem.toUpperCase();
//		}
		System.out.printf("MOCK: Notificacão seria enviado para %s através do e-mail %s: %s\n",
				cliente.getNome(), cliente.getEmail(),mensagem);
		
	}
	
	
}
