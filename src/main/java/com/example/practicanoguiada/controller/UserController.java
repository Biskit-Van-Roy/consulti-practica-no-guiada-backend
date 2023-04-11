package com.example.practicanoguiada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.practicanoguiada.DTO.LoginDTO;
import com.example.practicanoguiada.DTO.UserDTO;
import com.example.practicanoguiada.response.LoginResponse;
import com.example.practicanoguiada.services.UserService;

@RestController
@CrossOrigin(origins="*", maxAge=3600)
@RequestMapping("api/v1/user")
public class UserController {
	@Autowired
	private UserService userService;
	 /**
	  * Metodo para registrar el usuario
	  * @param userDTO
	  * @return id
	  */
	@PostMapping(path="/register")
	public String registerUser(@RequestBody UserDTO userDTO) {
		String id = userService.registerUser(userDTO);
		return id;
	}
	/**
	 * Metodo para logear usuario
	 * @param loginDTO
	 * @return ResponseEntity
	 */
	@PostMapping(path="/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginDTO loginDTO) {
		LoginResponse loginResponse = userService.loginUser(loginDTO);
		return ResponseEntity.ok(loginResponse);
	}
			
}
