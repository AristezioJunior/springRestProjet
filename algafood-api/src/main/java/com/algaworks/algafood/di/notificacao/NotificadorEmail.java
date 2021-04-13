package com.algaworks.algafood.di.notificacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;

//@Profile("prod")
@TipoDoNotificador(NivelUrgencia.NORMAL)
//@Primary //Dando prioridade a um Bean
//@Qualifier("email")
//Bean Spring
@Component
public class NotificadorEmail implements Notificador {
	
	/* 2.25
	@Value("${notificador.email.host-servidor}")
	private String host;
	@Value("${notificador.email.porta-servidor}")
	private Integer porta;
	*/
	//2.26
	@Autowired
	private NotificadorProperties properties;
	
//	private boolean caixaAlta;
//	private String hostServidorSmtp;
	
//	public NotificadorEmail(String hostServidorSmtp) {
//		
//		this.hostServidorSmtp = hostServidorSmtp;
//		System.out.println("Construtor da classe NotificadorEmail Chamado. O @Component gerencia os Beans.");
//	}
	
	//Construtor da aula 2.20
	public NotificadorEmail() {
		System.out.println("Notificador Email Real");
	}

	@Override
	public void notificar(Cliente cliente, String mensagem) {
//		if(this.caixaAlta) {
//			mensagem = mensagem.toUpperCase();
//		}
		System.out.println("Host: " + properties.getHostServidor());
		System.out.println("Porta: " + properties.getPortaServidor());
		
		System.out.printf("Notificando %s através do e-mail %s: %s\n",
				cliente.getNome(), cliente.getEmail(),mensagem);
	}
	

//	public void setCaixaAlta(boolean caixaAlta) {
//		this.caixaAlta = caixaAlta;
//	}
//	
	
	
}
