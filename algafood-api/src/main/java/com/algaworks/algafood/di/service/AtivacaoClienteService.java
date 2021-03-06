package com.algaworks.algafood.di.service;

//import javax.annotation.PostConstruct;
//import javax.annotation.PreDestroy;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
//import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.algaworks.algafood.di.modelo.Cliente;
import com.algaworks.algafood.di.notificacao.NivelUrgencia;
import com.algaworks.algafood.di.notificacao.Notificador;
import com.algaworks.algafood.di.notificacao.TipoDoNotificador;

@Component
public class AtivacaoClienteService {

	
	@TipoDoNotificador(NivelUrgencia.NORMAL)
	//@Autowired com (required = false) deixa a independencia não obrigatória
	//@Qualifier("whatsapp")
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
	
//	@PostConstruct
	public void init() {
		System.out.println("INIT " + notificador);
	}
	
//	@PreDestroy
	public void destroy() {
		System.out.println("DESTROY");
	}
	
	//2.22 Publicando e consumindo eventos customizados
			//dizer para container que o cliente esta ativo neste momento.
			@Autowired
			private ApplicationEventPublisher eventPublisher;
	
	public void ativar(Cliente cliente) {
		cliente.ativar();
		
		eventPublisher.publishEvent(new ClienteAtivadoEvent(cliente));
		
		
		//Utikizando List pois tem mais de um bean para Notificador
//		for (Notificador notificador : notificadores ) {
			/*if(notificador != null) {
				notificador.notificar(cliente, "Seu cadastro no sistema está ativo!");
			}else {
				System.out.println("Não existe notificador. Mas cliente foi ativado.");
//			}*/
				
			
		}
		
		
	}

//	@Autowired
//	public void setNotificador(Notificador notificador) {
//		this.notificador = notificador;
//	}
	
	
	
	


