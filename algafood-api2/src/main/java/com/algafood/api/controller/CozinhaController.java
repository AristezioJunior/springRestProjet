package com.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.algafood.api.model.CozinhasXmlWrapper;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;

/*@Controller //Componente Controlador
@ResponseBody //Vai ser uma resposta a requisição*/



@RestController // já tem dentro dela o @Controller e o @ResponseBody
@RequestMapping("cozinhas") //mapeando a URI
public class CozinhaController {
	
	@Autowired //Injetando
	private CozinhaRepository cozinhaRepository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE) //Requisição HTTP e produces informando que o metodo só produs um formato especifico
	public List<Cozinha> listar(){
		System.out.println("LISTAR COZINHA 1");
		return cozinhaRepository.todas();
	} 
	
	
	@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(cozinhaRepository.todas());
	}
	
	
	/*@GetMapping(produces = MediaType.APPLICATION_XML_VALUE) //Requisição HTTP e produces informando que o metodo só produs um formato especifico
	public List<Cozinha> listar2(){
		System.out.println("LISTAR COZINHA 2");
		return cozinhaRepository.todas();
	} */
	
	//@ResponseStatus(HttpStatus.CREATED) essa anotação muda o nome da resposta da aquisição, no caso deu 200 Ok, passa a ser 200 created.
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		Cozinha cozinha = cozinhaRepository.porId(cozinhaId);
		
		//return ResponseEntity.status(HttpStatus.OK).body(cozinha);
		//return ResponseEntity.ok(cozinha);
		
		HttpHeaders headers = new HttpHeaders();
		headers.add(HttpHeaders.LOCATION, "http://api.algafood.local:8080/cozinhas");
		
		
		return ResponseEntity
				.status(HttpStatus.FOUND)
				.headers(headers)
				.build();
		
		
	}
	
	
	
	
	
}
