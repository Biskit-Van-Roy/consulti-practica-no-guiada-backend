package com.example.practicanoguiada.services;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import com.example.practicanoguiada.model.Promociones;
import com.example.practicanoguiada.response.PromocionesResponseRest;

@Repository
public interface PromocionesService {
	public ResponseEntity<PromocionesResponseRest> search();
	public ResponseEntity<PromocionesResponseRest> searchById(Long id);
	public ResponseEntity<PromocionesResponseRest> save(Promociones promociones);
	public ResponseEntity<PromocionesResponseRest> update(Promociones promociones, Long id);
	public ResponseEntity<PromocionesResponseRest> deleteById(Long id);

}
