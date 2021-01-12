package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@Qualifier("whatsapp")
@Component
public class NotificadorWhatsApp  implements Notificador{

	@Override
	public void notificar(Cliente cliente, String mensagem) {
		System.out.printf("Notificando %s por WhatsApp através do telefone %s: %s\n",
				cliente.getNome(), cliente.getTelefone(),mensagem);
		
	}

}
