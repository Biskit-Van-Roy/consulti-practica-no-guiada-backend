package com.example.practicanoguiada.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.practicanoguiada.model.Evento;

@EnableJpaRepositories
public interface EventoRepo extends JpaRepository<Evento,Long>{
	
}
