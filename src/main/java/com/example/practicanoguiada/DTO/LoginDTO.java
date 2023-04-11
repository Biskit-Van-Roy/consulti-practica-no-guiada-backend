package com.example.practicanoguiada.DTO;

public class LoginDTO {
	private String user;
	private String password;
	private String rol;
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public LoginDTO(String user, String password, String rol) {
		super();
		this.user = user;
		this.password = password;
		this.rol = rol;
	}
	public LoginDTO() {
		super();
	}
	@Override
	public String toString() {
		return "LoginDTO [user=" + user + ", password=" + password + ", rol=" + rol + "]";
	}
	
}
