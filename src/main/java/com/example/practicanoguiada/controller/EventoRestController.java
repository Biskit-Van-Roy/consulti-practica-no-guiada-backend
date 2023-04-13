package com.example.practicanoguiada.controller;

import java.io.IOException;
import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	public ResponseEntity<EventoResponseRest> search(){
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
	@GetMapping("/filter/{nombre}")
	public ResponseEntity<EventoResponseRest> searchByNombre(@PathVariable String nombre){
		 ResponseEntity<EventoResponseRest> response = service.searchByNombre(nombre);
		 return response;
	}
	/**
	 * save user
	 * @param User
	 * @return
	 */
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
	public ResponseEntity<EventoResponseRest> update(@RequestParam(value="imagen",required=false) MultipartFile imagen,
			@RequestParam("fechas_compra") List<String> fechas_compra,
			@RequestParam("nombre") String nombre,
			@RequestParam("fecha") String fecha,
			@RequestParam("precio") double precio,
			@RequestParam("entradas") int entradas,
			@RequestParam("usuario_creador")String usuario_creador,
			@RequestParam("usuario_modificador") String usuario_modificador,
			@RequestParam("fecha_creacion") String fecha_creacion,
			@RequestParam("fecha_modificacion") String fecha_modificacion,
			@RequestParam("id_promocion") int id_promocion, 
			@PathVariable Long id)throws IOException {
		Evento evento = new Evento();
		evento.setNombre(nombre);
		evento.setEntradas(entradas);
		evento.setFecha(fecha_modificacion);
		evento.setFecha_creacion(fecha_creacion);
		evento.setFecha_modificacion(fecha_modificacion);
		evento.setFechas_compra(fechas_compra);
		evento.setId_promocion(id_promocion);
		evento.setPrecio(precio);
		evento.setUsuario_creador(usuario_creador);
		evento.setUsuario_modificador(usuario_modificador);
		
		 ResponseEntity<EventoResponseRest> response = service.update(evento, id);
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
