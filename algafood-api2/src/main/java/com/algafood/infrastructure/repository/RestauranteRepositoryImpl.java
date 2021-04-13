
package com.algafood.infrastructure.repository;

import static com.algafood.infrastructure.repository.spec.RestauranteSpecs.comFreteGratis;
import static com.algafood.infrastructure.repository.spec.RestauranteSpecs.comNomeSemelhante;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algafood.domain.model.Restaurante;
import com.algafood.domain.repository.RestauranteRepository;
import com.algafood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries{

	@PersistenceContext
	private EntityManager manager;
	
	
	@Autowired @Lazy
	private RestauranteRepository restauranteRepository;

	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		//AULA 5.13 / 5.14  5.15 implementando Criteria API
		//Fabrica para construir elementos para construir consultas e a propria Criteria
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);		
		Root<Restaurante> root = criteria.from(Restaurante.class); // from Restaurante
		
		var predicates = new ArrayList<Predicate>();
		
		//Estamos utilizando o Like na pesquisa
		if(StringUtils.hasText(nome)) {
		predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
		}
		
		
		//Maior que ou igual a = greater Than Or Equal To
		if(taxaFreteInicial != null){
		predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
		}
		
		//Menor que ou igual a = less than or equals to
		if(taxaFreteFinal != null) {
		predicates.add(builder.lessThan(root.get("taxaFrete"), taxaFreteFinal));
		}
		//transformando o arrayList em array
		criteria.where(predicates.toArray(new Predicate[0]));
		
		
		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		return query.getResultList();
 		
		
		
		//return manager.createQuery(criteria)
				//.getResultList();
	}

	@Override
	public List<Restaurante> findComFreteGratis(String nome) {
		return restauranteRepository.findAll(comFreteGratis()
				.and(comNomeSemelhante(nome)));
	}
	

	
	
	
		
		
		
	}
	
	
/*
//Aula 5.11
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
		
		//AULA 5.12
		var jpql = new StringBuilder();
		jpql.append("from Restaurante where 0 = 0 ");
		
		var parametros = new HashMap<String,Object>();
		
		
		//hasLength verifica se esta null ou se o indice é maior que 0
		if(StringUtils.hasLength(nome)) {
			jpql.append("and nome like :nome ");
			parametros.put("nome", "%" + nome + "%");
		}
		
		if(taxaFreteInicial != null) {
			jpql.append("and taxaFrete >= :taxaInicial ");
			parametros.put("taxaInicial", taxaFreteInicial);
		}
		
		if(taxaFreteFinal != null) {
			jpql.append("and taxaFrete <= :taxaFinal ");
			parametros.put("taxaFinal", taxaFreteFinal);
		}
		
		
		//var jpql = "from Restaurante where nome like :nome" + " and taxaFrete between :taxaInicial and :taxaFinal";
		
		TypedQuery<Restaurante> query = manager
				.createQuery(jpql.toString(), Restaurante.class);
		
		
		parametros.forEach((chave, valor) -> query.setParameter(chave,  valor));
							
		return query.getResultList();

*/




//AULAS MÓDULO 3
	/*@Override
	public List<Restaurante> listar(){
		
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();		
		
	}
	
	@Override
	public Restaurante buscar(Long id) {
		return manager.find(Restaurante.class, id);
	}
	
	
	@Transactional
	@Override
	public Restaurante salvar(Restaurante restaurante) {
		return manager.merge(restaurante);
		
	}
	
	@Transactional
	@Override
	public void remover(Restaurante restaurante) {
		restaurante = buscar(restaurante.getId());
		manager.remove(restaurante);
	}*/	
