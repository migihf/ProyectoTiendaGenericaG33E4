package mintic.edu.g33.e4.servicio;

import org.springframework.http.ResponseEntity;

import mintic.edu.g33.e4.modelo.Login;

public interface IUsuarioServicio {
	
	int login(Login usuario);
	
	ResponseEntity<?> ingresar(Login usuario);
	
}
