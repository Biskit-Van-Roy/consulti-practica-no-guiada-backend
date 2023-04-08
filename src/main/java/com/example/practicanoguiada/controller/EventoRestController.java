package com.example.practicanoguiada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practicanoguiada.model.Evento;
import com.example.practicanoguiada.response.EventoResponseRest;
import com.example.practicanoguiada.services.EventoService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/v1/evento")
public class EventoRestController {
	@Autowired
	private EventoService service;
	/**
	 * Obtener todos los eventos
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<EventoResponseRest> searchEvento(){
		 ResponseEntity<EventoResponseRest> response = service.search();
		 return response;
	}
	/**
	 * Obtener evento por Id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<EventoResponseRest> searchById(@PathVariable Long id){
		 ResponseEntity<EventoResponseRest> response = service.searchById(id);
		 return response;
	}
	/**
	 * save user
	 * @param User
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<EventoResponseRest> save(@RequestBody Evento evento){
		 ResponseEntity<EventoResponseRest> response = service.save(evento);
		 return response;
	}
	/**
	 * Actualizar evento
	 * @param user
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<EventoResponseRest> update(@RequestBody Evento evento, @PathVariable Long id){
		 ResponseEntity<EventoResponseRest> response = service.update(evento,id);
		 return response;
	}
	/**
	 * Borrar evento
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<EventoResponseRest> delete(@PathVariable Long id){
		 ResponseEntity<EventoResponseRest> response = service.deleteById(id);
		 return response;
	}
}
