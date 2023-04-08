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

import com.example.practicanoguiada.model.Compras;
import com.example.practicanoguiada.response.ComprasResponseRest;
import com.example.practicanoguiada.response.ComprasResponseRest;
import com.example.practicanoguiada.services.ComprasService;
import com.example.practicanoguiada.services.ComprasService;

@CrossOrigin(origins="*", maxAge=3600)
@RestController
@RequestMapping("/api/v1/compras")
public class ComprasRestController {
	@Autowired
	private ComprasService service;
	/**
	 * Obtener todos los comprass
	 * @return
	 */
	@GetMapping("/all")
	public ResponseEntity<ComprasResponseRest> searchCompras(){
		 ResponseEntity<ComprasResponseRest> response = service.search();
		 return response;
	}
	/**
	 * Obtener compras por Id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public ResponseEntity<ComprasResponseRest> searchById(@PathVariable Long id){
		 ResponseEntity<ComprasResponseRest> response = service.searchById(id);
		 return response;
	}
	/**
	 * save user
	 * @param User
	 * @return
	 */
	@PostMapping("/save")
	public ResponseEntity<ComprasResponseRest> save(@RequestBody Compras compras){
		 ResponseEntity<ComprasResponseRest> response = service.save(compras);
		 return response;
	}
	/**
	 * Actualizar compras
	 * @param user
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	public ResponseEntity<ComprasResponseRest> update(@RequestBody Compras compras, @PathVariable Long id){
		 ResponseEntity<ComprasResponseRest> response = service.update(compras,id);
		 return response;
	}
	/**
	 * Borrar compras
	 * @param id
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseEntity<ComprasResponseRest> delete(@PathVariable Long id){
		 ResponseEntity<ComprasResponseRest> response = service.deleteById(id);
		 return response;
	}
}
