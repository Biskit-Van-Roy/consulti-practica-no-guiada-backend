package com.example.practicanoguiada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="compras")
public class Compras {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Atributos del Evento
	 */
	private Long id;
	private String fecha_compra;
	private int id_evento;
	private int entradas;
	private String usuario_creador;
	private String usuario_modificador;
	private String fecha_creacion;
	private String fecha_modificacion;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFecha_compra() {
		return fecha_compra;
	}
	public void setFecha_compra(String fecha_compra) {
		this.fecha_compra = fecha_compra;
	}
	public int getId_evento() {
		return id_evento;
	}
	public void setId_evento(int id_evento) {
		this.id_evento = id_evento;
	}
	public int getEntradas() {
		return entradas;
	}
	public void setEntradas(int entradas) {
		this.entradas = entradas;
	}
	public String getUsuario_creador() {
		return usuario_creador;
	}
	public void setUsuario_creador(String usuario_creador) {
		this.usuario_creador = usuario_creador;
	}
	public String getUsuario_modificador() {
		return usuario_modificador;
	}
	public void setUsuario_modificador(String usuario_modificador) {
		this.usuario_modificador = usuario_modificador;
	}
	public String getFecha_creacion() {
		return fecha_creacion;
	}
	public void setFecha_creacion(String fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	public String getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Compras(Long id, String fecha_compra, int id_evento, int entradas, String usuario_creador,
			String usuario_modificador, String fecha_creacion, String fecha_modificacion) {
		super();
		this.id = id;
		this.fecha_compra = fecha_compra;
		this.id_evento = id_evento;
		this.entradas = entradas;
		this.usuario_creador = usuario_creador;
		this.usuario_modificador = usuario_modificador;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
	}
	public Compras() {
		super();
	}
	@Override
	public String toString() {
		return "Compras [id=" + id + ", fecha_compra=" + fecha_compra + ", id_evento=" + id_evento + ", entradas="
				+ entradas + ", usuario_creador=" + usuario_creador + ", usuario_modificador=" + usuario_modificador
				+ ", fecha_creacion=" + fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + "]";
	}
	
	
	
	

}
