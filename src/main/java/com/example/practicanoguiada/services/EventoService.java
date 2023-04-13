package com.example.practicanoguiada.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;


import com.example.practicanoguiada.model.Evento;
import com.example.practicanoguiada.response.EventoResponseRest;

@Repository
public interface EventoService {
	public ResponseEntity<EventoResponseRest> search();
	public ResponseEntity<EventoResponseRest> searchById(Long id);
	public ResponseEntity<EventoResponseRest> save(Evento evento);
	public ResponseEntity<EventoResponseRest> update(Evento evento, Long id);
	public ResponseEntity<EventoResponseRest> deleteById(Long id);
	public ResponseEntity<EventoResponseRest> searchByNombre(String nombre);
	public ResponseEntity<EventoResponseRest> findByNombreLike(String nombre);
}
