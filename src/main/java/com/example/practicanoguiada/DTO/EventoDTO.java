package com.example.practicanoguiada.DTO;

import java.util.Arrays;

public class EventoDTO {
	private Long id;
	private String fechas_compra;
	private String nombre;
	private String fecha;
	private byte[] imagen;
	private double precio;
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
	public String getFechas_compra() {
		return fechas_compra;
	}
	public void setFechas_compra(String fechas_compra) {
		this.fechas_compra = fechas_compra;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public byte[] getImagen() {
		return imagen;
	}
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
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
	public EventoDTO(Long id, String fechas_compra, String nombre, String fecha, byte[] imagen, double precio,
			int entradas, String usuario_creador, String usuario_modificador, String fecha_creacion,
			String fecha_modificacion) {
		super();
		this.id = id;
		this.fechas_compra = fechas_compra;
		this.nombre = nombre;
		this.fecha = fecha;
		this.imagen = imagen;
		this.precio = precio;
		this.entradas = entradas;
		this.usuario_creador = usuario_creador;
		this.usuario_modificador = usuario_modificador;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
	}
	public EventoDTO() {
		super();
	}
	@Override
	public String toString() {
		return "EventoDTO [id=" + id + ", fechas_compra=" + fechas_compra + ", nombre=" + nombre + ", fecha=" + fecha
				+ ", imagen=" + Arrays.toString(imagen) + ", precio=" + precio + ", entradas=" + entradas
				+ ", usuario_creador=" + usuario_creador + ", usuario_modificador=" + usuario_modificador
				+ ", fecha_creacion=" + fecha_creacion + ", fecha_modificacion=" + fecha_modificacion + "]";
	}
	
	
	
	
}
