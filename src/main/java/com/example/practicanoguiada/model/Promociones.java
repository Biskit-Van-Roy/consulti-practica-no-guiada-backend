package com.example.practicanoguiada.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="promociones")
public class Promociones implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Atributos de las promociones
	 */
	private Long id;
	private String fecha_inicio;
	private String fecha_final;
	private String nombre;
	private int tipo;
	private int descuento;
	private int vip;
	private String usuario_creador;
	private String usuario_modificador;
	private String fecha_creacion;
	private String fecha_modificacion;
	@ManyToOne(fetch = FetchType.LAZY)
	 @JoinColumn(name = "id_promocion")
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	private Evento evento;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFecha_inicio() {
		return fecha_inicio;
	}
	public void setFecha_inicio(String fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}
	public String getFecha_final() {
		return fecha_final;
	}
	public void setFecha_final(String fecha_final) {
		this.fecha_final = fecha_final;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getDescuento() {
		return descuento;
	}
	public void setDescuento(int descuento) {
		this.descuento = descuento;
	}
	public int getVip() {
		return vip;
	}
	public void setVip(int vip) {
		this.vip = vip;
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
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Promociones(Long id, String fecha_inicio, String fecha_final, String nombre, int tipo, int descuento,
			int vip, String usuario_creador, String usuario_modificador, String fecha_creacion,
			String fecha_modificacion, Evento evento) {
		super();
		this.id = id;
		this.fecha_inicio = fecha_inicio;
		this.fecha_final = fecha_final;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descuento = descuento;
		this.vip = vip;
		this.usuario_creador = usuario_creador;
		this.usuario_modificador = usuario_modificador;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
		this.evento = evento;
	}
	public Promociones() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Promociones [id=" + id + ", fecha_inicio=" + fecha_inicio + ", fecha_final=" + fecha_final + ", nombre="
				+ nombre + ", tipo=" + tipo + ", descuento=" + descuento + ", vip=" + vip + ", usuario_creador="
				+ usuario_creador + ", usuario_modificador=" + usuario_modificador + ", fecha_creacion="
				+ fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + ", evento=" + evento + "]";
	}

}
