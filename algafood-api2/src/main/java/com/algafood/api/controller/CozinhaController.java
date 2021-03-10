package com.algafood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import com.algafood.domain.exception.EntidadeEmUsoException;
import com.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algafood.domain.model.Cozinha;
import com.algafood.domain.repository.CozinhaRepository;
import com.algafood.domain.service.CadastroCozinhaService;

/*@Controller //Componente Controlador
@ResponseBody //Vai ser uma resposta a requisição*/



@RestController // já tem dentro dela o @Controller e o @ResponseBody
@RequestMapping("cozinhas") //mapeando a URI
public class CozinhaController {
	
	@Autowired //Injetando
	private CozinhaRepository cozinhaRepository;
	
	@Autowired
	private CadastroCozinhaService cadastroCozinha;

	@GetMapping /*(produces = MediaType.APPLICATION_JSON_VALUE) //Requisição HTTP e produces informando que o metodo só produs um formato especifico*/
	public List<Cozinha> listar(){
		//System.out.println("LISTAR COZINHA 1");
		return cozinhaRepository.todas();
	} 
	
	
	/*@GetMapping(produces = MediaType.APPLICATION_XML_VALUE)
	public CozinhasXmlWrapper listarXml(){
		return new CozinhasXmlWrapper(cozinhaRepository.todas());
	} */ 
	
	
	/*@GetMapping(produces = MediaType.APPLICATION_XML_VALUE) //Requisição HTTP e produces informando que o metodo só produs um formato especifico
	public List<Cozinha> listar2(){
		System.out.println("LISTAR COZINHA 2");
		return cozinhaRepository.todas();
	} */
	
	//Aula4.21
	@GetMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long cozinhaId) {
		
		Cozinha cozinha = cozinhaRepository.porId(cozinhaId);
		
		if(cozinha != null) {
			return ResponseEntity.ok(cozinha);
		}
		
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); ou
		return ResponseEntity.notFound().build();
	}
		
	//Aula4.20
	//@ResponseStatus(HttpStatus.CREATED) essa anotação muda o nome da resposta da aquisição, no caso deu 200 Ok, passa a ser 200 created.
	/*@GetMapping("/{cozinhaId}")
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
		
	}*/
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cadastroCozinha.salvar(cozinha);
	}
	
	@PutMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long cozinhaId, @RequestBody Cozinha cozinha){
		Cozinha cozinhaAtual = cozinhaRepository.porId(cozinhaId);
		
		if(cozinhaAtual != null) {
		/*cozinhaAtul.setNome(cozinha.getNome()); Como essa classe só tem a variavel nome podemos fazer assim
		Mas imagina uma classe com varias variaveis, pensando nisso podemos utilizar a classe BeanUtils*/
		BeanUtils.copyProperties(cozinha, cozinhaAtual,"id"); // Pegue o que tem em cozinha e jogue para cozinhaAtual
		
		cozinhaAtual = cadastroCozinha.salvar(cozinhaAtual);
		return ResponseEntity.ok(cozinhaAtual);
		}
		
		return ResponseEntity.notFound().build();
		
	}
	
	@DeleteMapping("/{cozinhaId}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long cozinhaId){
		try {
			cadastroCozinha.excluir(cozinhaId);
			
			return ResponseEntity.noContent().build();
			
			//return ResponseEntity.notFound().build();
	
		}catch(EntidadeNaoEncontradaException e) {
			return ResponseEntity.notFound().build();
		
		}catch(EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		
	}
	
	
	
	
}
