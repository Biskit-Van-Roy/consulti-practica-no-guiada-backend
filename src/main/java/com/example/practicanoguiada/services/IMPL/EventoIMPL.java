package com.example.practicanoguiada.services.IMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.practicanoguiada.response.*;
import com.example.practicanoguiada.services.EventoService;
import com.example.practicanoguiada.model.*;
import com.example.practicanoguiada.repo.EventoRepo;

@Service
public class EventoIMPL implements EventoService{
 @Autowired
	
	private EventoRepo eventoRepo;
 /**
  * Buscar los eventos
  */
 @Override
	@Transactional
	public ResponseEntity<EventoResponseRest> search() {
		EventoResponseRest response = new EventoResponseRest();
		try {
			List<Evento> evento = (List<Evento>) eventoRepo.findAll();
			response.getEventoResponse().setEvento(evento);;
			response.setMetadata("Respuesta correcta", "00", "Respuesta exitosa");
		} catch (Exception e) {
			
			response.setMetadata("Respuesta incorrecta", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
	}

@Override
public ResponseEntity<EventoResponseRest> searchById(Long id) {
	EventoResponseRest response = new EventoResponseRest();
	List<Evento> list = new ArrayList<>();
	try {
		Optional<Evento> evento = eventoRepo.findById(id);
		if(evento.isPresent()) {
			list.add(evento.get());
			response.getEventoResponse().setEvento(list);
			response.setMetadata("Respuesta correcta", "00", "Usuario encontrado");
		} else {
			response.setMetadata("Respuesta incorrecta", "-1", "Usuario no encontrado");
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} catch (Exception e){
		response.setMetadata("Respuesta incorrecta", "-1", "Error al consultar por id");
		e.getStackTrace();
		return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}

@Override
public ResponseEntity<EventoResponseRest> save(Evento evento) {
	List<Evento> list = new ArrayList<>();
	EventoResponseRest response = new EventoResponseRest();
	try {
		Evento eventoSaved = eventoRepo.save(evento);
		if(eventoSaved != null) {
			list.add(eventoSaved);
			response.getEventoResponse().setEvento(list);
			response.setMetadata("Respuesta correcta", "00", "Usuario guardado");
		} else {
			response.setMetadata("Respuesta icorrecta", "-1", "Usuario no guardado");
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.BAD_REQUEST);
		}
		
	}
	 catch (Exception e){
			response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar uuario");
			e.getStackTrace();
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}

@Override
public ResponseEntity<EventoResponseRest> update(Evento evento, Long id) {
	EventoResponseRest response = new EventoResponseRest();
	List<Evento> list = new ArrayList<>();
	try {
		Optional<Evento> eventoSearch = eventoRepo.findById(id);
		if(eventoSearch.isPresent()) {
			//Save the register
			eventoSearch.get().setEntradas(evento.getEntradas());
			eventoSearch.get().setFecha(evento.getFecha());
			eventoSearch.get().setFechas_compra(evento.getFechas_compra());
			eventoSearch.get().setImagen(evento.getImagen());
			eventoSearch.get().setNombre(evento.getNombre());
			eventoSearch.get().setPrecio(evento.getPrecio());
			eventoSearch.get().setUsuario_modificador("admin");
			eventoSearch.get().setFecha_modificacion(evento.getFecha_modificacion());
		
			
			Evento eventoToUpdate = eventoRepo.save(eventoSearch.get());
			if(eventoToUpdate != null) {
				list.add(eventoToUpdate);
				response.getEventoResponse().setEvento(list);
				response.setMetadata("Respuesta correcta", "00", "Usuario actualizado");
				
			}
			
			
		} else {
			response.setMetadata("Respuesta incorrecta", "-1", " Usuario no actualizado");
			return new ResponseEntity<EventoResponseRest>(response, HttpStatus.BAD_REQUEST);
		}
		
	} catch (Exception e){
		response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar usuario");
		e.getStackTrace();
		return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}

@Override
public ResponseEntity<EventoResponseRest> deleteById(Long id) {
	EventoResponseRest response = new EventoResponseRest();
	try {
		eventoRepo.deleteById(id);
		response.setMetadata("Respuesta correcta", "00", "Registro eliminado");
	}catch (Exception e) {
		response.setMetadata("Respuesta incorecta", "-1","Error al eliminar");
		e.getStackTrace();
		return new ResponseEntity<EventoResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}
}
