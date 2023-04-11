package com.example.practicanoguiada.services;

import org.springframework.stereotype.Repository;

import com.example.practicanoguiada.DTO.LoginDTO;
import com.example.practicanoguiada.DTO.UserDTO;
import com.example.practicanoguiada.response.LoginResponse;

@Repository
public interface UserService {
	String registerUser(UserDTO userDTO);

	LoginResponse loginUser(LoginDTO loginDTO);
}
