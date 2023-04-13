package com.example.practicanoguiada.services.IMPL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.practicanoguiada.response.*;
import com.example.practicanoguiada.services.EventoService;
import com.example.practicanoguiada.util.Util;
import com.example.practicanoguiada.model.*;
import com.example.practicanoguiada.repo.EventoRepo;

@Service
public class EventoIMPL implements EventoService{

	
	private EventoRepo eventoRepo;
	public EventoIMPL(EventoRepo eventoRepo) {
		super();
		this.eventoRepo = eventoRepo;
	}
 /**
  * Buscar los eventos
  */
 @Override
 @Transactional(readOnly=true)
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

/**
 * Buscar evento  por id
 */
@Override
@Transactional(readOnly=false)
public ResponseEntity<EventoResponseRest> searchById(Long id) {
	EventoResponseRest response = new EventoResponseRest();
	List<Evento> list = new ArrayList<>();
	try {
		Optional<Evento> evento = eventoRepo.findById(id);
		if(evento.isPresent()) {
			// Para descomprimir la imagen
			//byte[] imageDescompressed = Util.decompressZLib(evento.get().getImagen());
			//evento.get().setImagen(imageDescompressed);
			list.add(evento.get());
			response.getEventoResponse().setEvento(list);
			response.setMetadata("Respuesta correcta", "00", "Evento encontrado");
		} else {
			response.setMetadata("Respuesta incorrecta", "-1", "Evento no encontrado");
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} catch (Exception e){
		response.setMetadata("Respuesta incorrecta", "-1", "Error al consultar por id el evento");
		e.getStackTrace();
		return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}
/**
 * Guardar evento
 */
@Override
@Transactional(readOnly=false)
public ResponseEntity<EventoResponseRest> save(Evento evento) {
	
	EventoResponseRest response = new EventoResponseRest();
	List<Evento> list = new ArrayList<>();
	try {
		//Guardar evento
		Evento eventoSaved = eventoRepo.save(evento);
		list.add(eventoSaved);
		if(eventoSaved!= null) {
			response.getEventoResponse().setEvento(list);
			response.setMetadata("Respuesta correcta", "00", "Evento guardado");	
		}
		else {
			response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar evento");
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	 catch (Exception e){
			response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar evento");
			e.getStackTrace();
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}
/**
 * Actualizar evento
 */
@Override
@Transactional
public ResponseEntity<EventoResponseRest> update(Evento evento, Long id) {
	EventoResponseRest response = new EventoResponseRest();
	List<Evento> list = new ArrayList<>();
	try {
		Optional<Evento> eventoSearch = eventoRepo.findById(id);
		if(eventoSearch.isPresent()) {
			//Save the register
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
			   LocalDateTime now = LocalDateTime.now();
			eventoSearch.get().setEntradas(evento.getEntradas());
			eventoSearch.get().setFecha(evento.getFecha());
			eventoSearch.get().setFechas_compra(evento.getFechas_compra());
			eventoSearch.get().setImagen(evento.getImagen());
			eventoSearch.get().setNombre(evento.getNombre());
			eventoSearch.get().setPrecio(evento.getPrecio());
			eventoSearch.get().setUsuario_modificador("admin");
			eventoSearch.get().setFecha_modificacion(dtf.format(now));
		
			
			Evento eventoToUpdate = eventoRepo.save(eventoSearch.get());
			if(eventoToUpdate != null) {
				list.add(eventoToUpdate);
				response.getEventoResponse().setEvento(list);
				response.setMetadata("Respuesta correcta", "00", "Evento actualizado");
				
			}else {
				response.setMetadata("Respuesta incorrecta", "-1", " Evento no actualizado");
				return new ResponseEntity<EventoResponseRest>(response, HttpStatus.BAD_REQUEST);
			
			
		} 
		}
		
	} catch (Exception e){
		response.setMetadata("Respuesta incorrecta", "-1", "No se actualizo el producto");
		e.getStackTrace();
		return new ResponseEntity<EventoResponseRest>(response,HttpStatus.NOT_FOUND);
	}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}
/**
 * Borrar por id
 */
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
/**
 * Buscar por nombre
 */

@Override
@Transactional(readOnly=false)
public ResponseEntity<EventoResponseRest> findByNombreLike(String nombre) {
	EventoResponseRest response = new EventoResponseRest();
	List<Evento> list = new ArrayList<>();
	List<Evento> listAux = new ArrayList<>();
	try {
		listAux=eventoRepo.findByNombreContainingIgnoreCase(nombre);
		
		
		if(listAux.size()>0) {
			listAux.stream().forEach((e)->{
				// Para descomprimir la imagen
				list.add(e);
				
			});
		
			response.getEventoResponse().setEvento(list);
			response.setMetadata("Respuesta correcta", "00", "Eventos encontrados");
		} else {
			response.setMetadata("Respuesta incorrecta", "-1", "Eventos no encontrados");
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} catch (Exception e){
		response.setMetadata("Respuesta incorrecta", "-1", "Error al buecar por nombre el evento");
		e.getStackTrace();
		return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}
@Override
@Transactional(readOnly=false)
public ResponseEntity<EventoResponseRest> searchByNombre(String nombre) {
	EventoResponseRest response = new EventoResponseRest();
	List<Evento> list = new ArrayList<>();
	List<Evento> listAux = new ArrayList<>();
	try {
		listAux=eventoRepo.findByNombreContainingIgnoreCase(nombre);
		
		
		if(listAux.size()>0) {
			listAux.stream().forEach((e)->{
				// Para descomprimir la imagen
				byte[] imageDescompressed = Util.decompressZLib(e.getImagen());
				e.setImagen(imageDescompressed);
				list.add(e);
			});
		
			response.getEventoResponse().setEvento(list);
			response.setMetadata("Respuesta correcta", "00", "Eventos encontrados");
		} else {
			response.setMetadata("Respuesta incorrecta", "-1", "Eventos no encontrados");
			return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} catch (Exception e){
		response.setMetadata("Respuesta incorrecta", "-1", "Error al buecar por nombre el evento");
		e.getStackTrace();
		return new ResponseEntity<EventoResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<EventoResponseRest>(response,HttpStatus.OK);
}
}
