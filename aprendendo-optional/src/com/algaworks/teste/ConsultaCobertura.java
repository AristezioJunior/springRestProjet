package com.algaworks.teste;

import com.algaworks.model.Caminhao;
import com.algaworks.model.Motorista;
import com.algaworks.model.Seguro;
import com.algaworks.repository.Motoristas;

public class ConsultaCobertura {

	public static void main(String[] args) {

		Motoristas motoristas = new Motoristas();
		//Motorista motorista = motoristas.porNome("Maria"); // se o motorista nao ter caminh�o vai da nullPoint Exception
		
		//String cobertura = motorista.getCaminhao().getSeguro().getCobertura();
		/*String cobertura = "Sem seguro";
		//Dessa forma para chegar em Cobertura do Seguro e n�o gerar o erro de NullPoint
		if(motorista != null) {
			Caminhao caminhao = motorista.getCaminhao();
			if(caminhao != null) {
				Seguro seguro = caminhao.getSeguro();
				if(seguro != null) {
					cobertura = seguro.getCobertura();
				}
			}
		}		
				*/
		
		//Optional<Motorista> motoristaOpcional = motoristas.porNome("Jo�o");
	
		//Optional<Caminhao> caminhaoOpcional = motoristaOpcional.flatMap(Motorista::getCaminhao);
		
		//flatMap agrupa os Optional de Optional
		String cobertura = motoristas.porNome("Jo�o")
								.flatMap(Motorista::getCaminhao)
								.flatMap(Caminhao::getSeguro)
								.map(Seguro::getCobertura)
								.orElse("Sem cobertura");
								
		//coberturaOpcional.ifPresent(System.out::println);
		
		System.out.println("A cobertura �: " + cobertura);

		
		
	}

}
