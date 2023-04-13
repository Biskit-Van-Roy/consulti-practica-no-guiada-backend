package com.example.practicanoguiada.services.IMPL;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.practicanoguiada.model.Evento;
import com.example.practicanoguiada.model.Promociones;
import com.example.practicanoguiada.repo.EventoRepo;
import com.example.practicanoguiada.repo.PromocionesRepo;
import com.example.practicanoguiada.response.PromocionesResponseRest;
import com.example.practicanoguiada.services.PromocionesService;

@Service
public class PromocionesIMPL implements PromocionesService {
	@Autowired
	private PromocionesRepo promocionesRepo;
	
	
	private EventoRepo eventoRepo;
	
	public PromocionesIMPL(EventoRepo eventoRepo) {
		super();
		this.eventoRepo = eventoRepo;
	}
 /**
  * Buscar los promociones
  */
 @Override
	@Transactional
	public ResponseEntity<PromocionesResponseRest> search() {
		PromocionesResponseRest response = new PromocionesResponseRest();
		try {
			List<Promociones> promociones = (List<Promociones>) promocionesRepo.findAll();
			response.getPromocionesResponse().setPromociones(promociones);
			response.setMetadata("Respuesta correcta", "00", "Respuesta exitosa");
		} catch (Exception e) {
			
			response.setMetadata("Respuesta incorrecta", "-1", "Error al consultar");
			e.getStackTrace();
			return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.OK);
	}

@Override
public ResponseEntity<PromocionesResponseRest> searchById(Long id) {
	PromocionesResponseRest response = new PromocionesResponseRest();
	List<Promociones> list = new ArrayList<>();
	try {
		Optional<Promociones> promociones = promocionesRepo.findById(id);
		if(promociones.isPresent()) {
			list.add(promociones.get());
			response.getPromocionesResponse().setPromociones(list);
			response.setMetadata("Respuesta correcta", "00", "Usuario encontrado");
		} else {
			response.setMetadata("Respuesta incorrecta", "-1", "Usuario no encontrado");
			return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} catch (Exception e){
		response.setMetadata("Respuesta incorrecta", "-1", "Error al consultar por id");
		e.getStackTrace();
		return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.OK);
}
@Override
public ResponseEntity<PromocionesResponseRest> save(Promociones promociones,Long eventoId) {
	
	PromocionesResponseRest response = new PromocionesResponseRest();
	List<Promociones> list = new ArrayList<>();
	try {
		Optional<Evento> evento = eventoRepo.findById(eventoId);
		if(evento.isPresent()) {
			promociones.setEvento(evento.get());
		} else {
			response.setMetadata("Respuesta icorrecta", "-1", "categoria no encontrada");
			return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.NOT_FOUND);
		}
		Promociones promocionesSaved = promocionesRepo.save(promociones);
		if(promocionesSaved != null) {
			list.add(promocionesSaved);
			response.getPromocionesResponse().setPromociones(list);
			response.setMetadata("Respuesta correcta", "00", "Usuario guardado");
		} else {
			response.setMetadata("Respuesta icorrecta", "-1", "Usuario no guardado");
			return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.BAD_REQUEST);
		}
		
		
	}
	 catch (Exception e){
			response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar uuario");
			e.getStackTrace();
			return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.OK);
}
/*@Override
public ResponseEntity<PromocionesResponseRest> save(Promociones promociones, Long eventoId) {
	
	PromocionesResponseRest response = new PromocionesResponseRest();
	List<Promociones> list = new ArrayList<>();
	try {
		//Buscar el evento para setear la promocion
		Optional<Evento> evento = eventoRepo.findById(eventoId);
		if(evento.isPresent()) {
			promociones.setEventos(evento.get());
		} else {
			response.setMetadata("Respuesta incorrecta", "-1", "Evento no encontrado");
			return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.NOT_FOUND);
		}
		//Guardar la promocion
		Promociones promocionesSaved = promocionesRepo.save(promociones);
		if(promocionesSaved != null) {
			list.add(promocionesSaved);
			response.getPromocionesResponse().setPromociones(list);
			response.setMetadata("Respuesta correcta", "00", "Promocion guardada");
		} else {
			response.setMetadata("Respuesta icorrecta", "-1", "Promocion no guardada");
			return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.BAD_REQUEST);
		}
		
	}
	 catch (Exception e){
			response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar la promocion");
			e.getStackTrace();
			return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.OK);
}
*/
@Override
public ResponseEntity<PromocionesResponseRest> update(Promociones promociones, Long id) {
	PromocionesResponseRest response = new PromocionesResponseRest();
	List<Promociones> list = new ArrayList<>();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	   LocalDateTime now = LocalDateTime.now(); 
	try {
		Optional<Promociones> promocionesSearch = promocionesRepo.findById(id);
		if(promocionesSearch.isPresent()) {
			//Save the register
			promocionesSearch.get().setFecha_inicio(promociones.getFecha_inicio());
			promocionesSearch.get().setFecha_final(promociones.getFecha_final());
			promocionesSearch.get().setNombre(promociones.getNombre());
			promocionesSearch.get().setTipo(promociones.getTipo());
			promocionesSearch.get().setDescuento(promociones.getDescuento());
			promocionesSearch.get().setUsuario_modificador("admin");
			promocionesSearch.get().setFecha_modificacion(dtf.format(now));
		
		
			
			Promociones promocionesToUpdate = promocionesRepo.save(promocionesSearch.get());
			if(promocionesToUpdate != null) {
				list.add(promocionesToUpdate);
				response.getPromocionesResponse().setPromociones(list);
				response.setMetadata("Respuesta correcta", "00", "Usuario actualizado");
				
			}
			
			
		} else {
			response.setMetadata("Respuesta incorrecta", "-1", " Usuario no actualizado");
			return new ResponseEntity<PromocionesResponseRest>(response, HttpStatus.BAD_REQUEST);
		}
		
	} catch (Exception e){
		response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar usuario");
		e.getStackTrace();
		return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.OK);
}

@Override
public ResponseEntity<PromocionesResponseRest> deleteById(Long id) {
	PromocionesResponseRest response = new PromocionesResponseRest();
	try {
		promocionesRepo.deleteById(id);
		response.setMetadata("Respuesta correcta", "00", "Registro eliminado");
	}catch (Exception e) {
		response.setMetadata("Respuesta incorecta", "-1","Error al eliminar");
		e.getStackTrace();
		return new ResponseEntity<PromocionesResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return new ResponseEntity<PromocionesResponseRest>(response,HttpStatus.OK);
}
}
