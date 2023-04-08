package com.example.practicanoguiada.services.IMPL;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.practicanoguiada.model.Compras;
import com.example.practicanoguiada.repo.ComprasRepo;
import com.example.practicanoguiada.response.ComprasResponseRest;
import com.example.practicanoguiada.services.ComprasService;

@Service
public class ComprasIMPL implements ComprasService {
	 @Autowired
		
		private ComprasRepo comprasRepo;
	 /**
	  * Buscar los comprass
	  */
	 @Override
		@Transactional
		public ResponseEntity<ComprasResponseRest> search() {
			ComprasResponseRest response = new ComprasResponseRest();
			try {
				List<Compras> compras = (List<Compras>) comprasRepo.findAll();
				response.getComprasResponse().setCompras(compras);;
				response.setMetadata("Respuesta correcta", "00", "Respuesta exitosa");
			} catch (Exception e) {
				
				response.setMetadata("Respuesta incorrecta", "-1", "Error al consultar");
				e.getStackTrace();
				return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
			
			return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.OK);
		}

	@Override
	public ResponseEntity<ComprasResponseRest> searchById(Long id) {
		ComprasResponseRest response = new ComprasResponseRest();
		List<Compras> list = new ArrayList<>();
		try {
			Optional<Compras> compras = comprasRepo.findById(id);
			if(compras.isPresent()) {
				list.add(compras.get());
				response.getComprasResponse().setCompras(list);
				response.setMetadata("Respuesta correcta", "00", "Usuario encontrado");
			} else {
				response.setMetadata("Respuesta incorrecta", "-1", "Usuario no encontrado");
				return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e){
			response.setMetadata("Respuesta incorrecta", "-1", "Error al consultar por id");
			e.getStackTrace();
			return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ComprasResponseRest> save(Compras compras) {
		List<Compras> list = new ArrayList<>();
		ComprasResponseRest response = new ComprasResponseRest();
		try {
			Compras comprasSaved = comprasRepo.save(compras);
			if(comprasSaved != null) {
				list.add(comprasSaved);
				response.getComprasResponse().setCompras(list);
				response.setMetadata("Respuesta correcta", "00", "Usuario guardado");
			} else {
				response.setMetadata("Respuesta icorrecta", "-1", "Usuario no guardado");
				return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.BAD_REQUEST);
			}
			
		}
		 catch (Exception e){
				response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar uuario");
				e.getStackTrace();
				return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ComprasResponseRest> update(Compras compras, Long id) {
		ComprasResponseRest response = new ComprasResponseRest();
		List<Compras> list = new ArrayList<>();
		try {
			Optional<Compras> comprasSearch = comprasRepo.findById(id);
			if(comprasSearch.isPresent()) {
				//Save the register
				comprasSearch.get().setEntradas(compras.getEntradas());
				comprasSearch.get().setFecha_compra(compras.getFecha_compra());
				comprasSearch.get().setId_evento(compras.getId_evento());
				
				comprasSearch.get().setUsuario_modificador("admin");
				comprasSearch.get().setFecha_modificacion(compras.getFecha_modificacion());
			
				
				Compras comprasToUpdate = comprasRepo.save(comprasSearch.get());
				if(comprasToUpdate != null) {
					list.add(comprasToUpdate);
					response.getComprasResponse().setCompras(list);
					response.setMetadata("Respuesta correcta", "00", "Usuario actualizado");
					
				}
				
				
			} else {
				response.setMetadata("Respuesta incorrecta", "-1", " Usuario no actualizado");
				return new ResponseEntity<ComprasResponseRest>(response, HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e){
			response.setMetadata("Respuesta incorrecta", "-1", "Error al grabar usuario");
			e.getStackTrace();
			return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ComprasResponseRest> deleteById(Long id) {
		ComprasResponseRest response = new ComprasResponseRest();
		try {
			comprasRepo.deleteById(id);
			response.setMetadata("Respuesta correcta", "00", "Registro eliminado");
		}catch (Exception e) {
			response.setMetadata("Respuesta incorecta", "-1","Error al eliminar");
			e.getStackTrace();
			return new ResponseEntity<ComprasResponseRest>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ComprasResponseRest>(response,HttpStatus.OK);
	}
}
