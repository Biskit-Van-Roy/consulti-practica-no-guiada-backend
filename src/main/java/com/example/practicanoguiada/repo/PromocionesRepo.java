package com.example.practicanoguiada.repo;



import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.example.practicanoguiada.model.Promociones;

@EnableJpaRepositories
public interface PromocionesRepo extends CrudRepository<Promociones,Long> {
	
}	