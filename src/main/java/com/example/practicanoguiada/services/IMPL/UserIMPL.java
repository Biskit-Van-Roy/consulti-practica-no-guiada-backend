package com.example.practicanoguiada.services.IMPL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.practicanoguiada.model.*;
import com.example.practicanoguiada.DTO.LoginDTO;
import com.example.practicanoguiada.DTO.UserDTO;
import com.example.practicanoguiada.repo.UserRepo;
import com.example.practicanoguiada.response.LoginResponse;
import com.example.practicanoguiada.services.UserService;

@Service
public class UserIMPL implements UserService{
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Override
	public String registerUser(UserDTO userDTO) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
		   LocalDateTime now = LocalDateTime.now();
		User user = new User(
				userDTO.getId(),
				userDTO.getUser(),
				userDTO.getNombres(),
				userDTO.getApellidos(),
				userDTO.getEmail(),
				this.passwordEncoder.encode(userDTO.getPassword()),
				userDTO.getUser(),
				userDTO.getUser(),
				dtf.format(now),
				dtf.format(now),
				userDTO.getRol()
				) ;
		userRepo.save(user);
		return user.getUser();
	}
	@Override
	public LoginResponse loginUser(LoginDTO loginDTO) {
		System.out.print(loginDTO.getUser());
		
		User userencontrado = userRepo.findByUser(loginDTO.getUser());
		System.out.println(userencontrado);
		if(userencontrado != null) {
			String password = loginDTO.getPassword();
			String encodedPassword = userencontrado.getPassword();
			System.out.println(encodedPassword);
			System.out.println(password);
			System.out.println(this.passwordEncoder.encode(password));
			Boolean esCorrecta = passwordEncoder.matches(password, encodedPassword);
			System.out.println(esCorrecta);
			if(esCorrecta) {
				Optional<User> user = userRepo.findOneByUserAndPassword(loginDTO.getUser(),encodedPassword);
				if(user.isPresent()&& userencontrado.getRol()==1) {
					return new LoginResponse("Login correcto admin",true);
				} else if(user.isPresent()&& userencontrado.getRol()==2) {
					return new LoginResponse("Login correcto user",true);
				} else {
					return new LoginResponse("Login falló",false);
				}
			} else {
				return new LoginResponse("Password mal", false);
			}
		} else {
			return new LoginResponse("El correo no existe", false);
		}
		
	}
}
