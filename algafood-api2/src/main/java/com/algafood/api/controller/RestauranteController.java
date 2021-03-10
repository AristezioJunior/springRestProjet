package com.algafood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;


@RestController // já tem dentro dela o @Controller e o @ResponseBody
@RequestMapping("restaurantes") //mapeando a URI
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	
	
	@GetMapping /*(produces = MediaType.APPLICATION_JSON_VALUE) //Requisição HTTP e produces informando que o metodo só produs um formato especifico*/
	public List<Restaurante> listar(){
		//System.out.println("LISTAR COZINHA 1");
		return restauranteRepository.listar();
	} 
	
	
	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);
		
		if(restaurante != null) {
			return ResponseEntity.ok(restaurante);
		}
		
		//return ResponseEntity.status(HttpStatus.NOT_FOUND).build(); ou
		return ResponseEntity.notFound().build();
	}
	
	
	
	
	
	
}
