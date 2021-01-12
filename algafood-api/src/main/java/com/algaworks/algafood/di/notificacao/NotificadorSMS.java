package com.algaworks.algafood.di.notificacao;

//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)
//@Qualifier("sms")
@Component
public class NotificadorSMS implements Notificador{

//	private boolean caixaAlta;
//	private String hostServidorSmtp;
	
//	public NotificadorEmail(String hostServidorSmtp) {
//		
//		this.hostServidorSmtp = hostServidorSmtp;
//		System.out.println("Construtor da classe NotificadorEmail Chamado. O @Component gerencia os Beans.");
//	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
//		if(this.caixaAlta) {
//			mensagem = mensagem.toUpperCase();
//		}
		System.out.printf("Notificando %s por SMS através do telefone %s: %s\n",
				cliente.getNome(), cliente.getTelefone(),mensagem);
		
	}

//	public void setCaixaAlta(boolean caixaAlta) {
//		this.caixaAlta = caixaAlta;
//	}
//	

}
