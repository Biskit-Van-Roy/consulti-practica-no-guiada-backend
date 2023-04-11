package com.example.practicanoguiada.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="user")
public class User {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	/**
	 * Atributos del Evento
	 */
	private Long id;
	private String user;
	private String nombres;
	private String apellidos;
	private String email;
	private String password;
	private String usuario_creador;
	private String usuario_modificador;
	private String fecha_creacion;
	private String fecha_modificacion;
	private int rol;

	/**
	 * Superconstructor vacio
	 */
	public User() {
		super();
	}
	/**
	 * Getters y Setters de Usuario
	 * @return
	 */
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public int getRol() {
		return rol;
	}
	public void setRol(int rol) {
		this.rol = rol;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	/**
	 * Constructor con los campos
	 * @param id
	 * @param user
	 * @param nombres
	 * @param apellidos
	 * @param email
	 * @param password
	 * @param rol
	 */
	public User(Long id, String user, String nombres, String apellidos, String email, String password,
			String usuario_creador, String usuario_modificador, String fecha_creacion, String fecha_modificacion,
			int rol) {
		super();
		this.id = id;
		this.user = user;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.email = email;
		this.password = password;
		this.usuario_creador = usuario_creador;
		this.usuario_modificador = usuario_modificador;
		this.fecha_creacion = fecha_creacion;
		this.fecha_modificacion = fecha_modificacion;
		this.rol = rol;
	}	
	/**
	 * Generar el ToString
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", user=" + user + ", nombres=" + nombres + ", apellidos=" + apellidos + ", email="
				+ email + ", password=" + password + ", rol=" + rol + "]";
	}

}
