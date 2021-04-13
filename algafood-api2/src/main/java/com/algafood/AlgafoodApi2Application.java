package com.algafood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.algafood.infrastructure.repository.spec.CustomJpaRepositoryImp;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImp.class)
public class AlgafoodApi2Application {

	public static void main(String[] args) {
		SpringApplication.run(AlgafoodApi2Application.class, args);
	}

}
