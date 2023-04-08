package com.example.practicanoguiada.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.example.practicanoguiada.model.Compras;

import com.example.practicanoguiada.response.ComprasResponseRest;


@Repository
public interface ComprasService {
	public ResponseEntity<ComprasResponseRest> search();
	public ResponseEntity<ComprasResponseRest> searchById(Long id);
	public ResponseEntity<ComprasResponseRest> save(Compras compras);
	public ResponseEntity<ComprasResponseRest> update(Compras compras, Long id);
	public ResponseEntity<ComprasResponseRest> deleteById(Long id);
}
