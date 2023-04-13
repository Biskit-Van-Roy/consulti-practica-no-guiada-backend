package com.example.practicanoguiada.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

import com.example.practicanoguiada.model.Evento;

@EnableJpaRepositories
public interface EventoRepo extends CrudRepository<Evento,Long>{
	/**
	 * Metodo para buscar por nombre
	 */
	@Query("select e from Evento e where e.nombre like %?1%")
	List<Evento> findByNombreLike(String nombre);
	List<Evento> findByNombreContainingIgnoreCase(String nombre);
	
	
}
