package com.example.practicanoguiada.controller;

import java.io.IOException;

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

import com.example.practicanoguiada.model.Promociones;
import com.example.practicanoguiada.response.PromocionesResponseRest;
import com.example.practicanoguiada.services.PromocionesService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/v1/promociones")
public class PromocionesRestController {
	private PromocionesService service;
	
	
	
	public PromocionesRestController(PromocionesService service) {
		super();
		this.service = service;
	}
	/**
	 * Obtener todos los promocioness
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<PromocionesResponseRest> searchPromociones(){
		 ResponseEntity<PromocionesResponseRest> response = service.search();
		 return response;
	}
	/**
	 * Obtener promociones por Id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<PromocionesResponseRest> searchById(@PathVariable Long id){
		 ResponseEntity<PromocionesResponseRest> response = service.searchById(id);
		 return response;
	}
	/**
	 * save user
	 * @param User
	 * @return
	 */
	/*@PostMapping("/save")
	public ResponseEntity<PromocionesResponseRest> save(@RequestBody Promociones promociones){
		 ResponseEntity<PromocionesResponseRest> response = service.save(promociones);
		 return response;
	}*/
	@PostMapping("/save")
	public ResponseEntity<PromocionesResponseRest> save(
			@RequestParam("nombre") String nombre,
			@RequestParam("fecha_inicio") String fecha_inicio,
			@RequestParam("fecha_final") String fecha_final,
			@RequestParam("tipo") int tipo,
			@RequestParam("descuento") int descuento,
			@RequestParam("vip") int vip,
			@RequestParam("eventoId") Long eventoId
			) throws IOException{
			Promociones promociones = new Promociones();
			promociones.setNombre(nombre);
			promociones.setDescuento(descuento);
			promociones.setFecha_inicio(fecha_inicio);
			promociones.setFecha_final(fecha_final);
			promociones.setTipo(tipo);
			promociones.setVip(vip);
			promociones.setUsuario_creador("admin");
			promociones.setUsuario_modificador("admin");
			promociones.setFecha_creacion(fecha_inicio);
			promociones.setFecha_modificacion(fecha_final);
			System.out.print(promociones);
		 ResponseEntity<PromocionesResponseRest> response = service.save(promociones, eventoId);
		 return response;
	}
	/**
	 * Actualizar promociones
	 * @param user
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<PromocionesResponseRest> update(@RequestBody Promociones promociones, @PathVariable Long id){
		 ResponseEntity<PromocionesResponseRest> response = service.update(promociones,id);
		 return response;
	}
	/**
	 * Borrar promociones
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<PromocionesResponseRest> delete(@PathVariable Long id){
		 ResponseEntity<PromocionesResponseRest> response = service.deleteById(id);
		 return response;
	}
}
