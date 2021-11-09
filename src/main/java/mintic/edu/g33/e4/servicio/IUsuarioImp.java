package mintic.edu.g33.e4.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import mintic.edu.g33.e4.modelo.Login;
import mintic.edu.g33.e4.modelo.Usuario;
import mintic.edu.g33.e4.repositorio.IUsuario;

@Service
public class IUsuarioImp implements IUsuarioServicio {
	
	@Autowired
	IUsuario iUsuario;
	
	@Override
	public int login(Login usuario) {
		int u=iUsuario.findByNombreUsuarioAndPassword(usuario.getNombreUsuario(), usuario.getPsswrd());
		return u;
	}

	@Override
	public ResponseEntity<?> ingresar(Login usuario) {
		Map<String, Object> response=new HashMap<>();
		Usuario user=null;
		try {
			user=iUsuario.findByNombreAndPassword(usuario.getNombreUsuario(), usuario.getPsswrd());
			if(user==null) {
				response.put("Usuario", null);
				response.put("Mensaje", "Alerta:Usuario o Password incorrectos");
				response.put("statusCode", HttpStatus.OK.value());
				return new ResponseEntity<>(response,HttpStatus.OK);
				
			}else {
				response.put("Usuario", usuario);
				response.put("Mensaje", "Datos correctos");
				response.put("statusCode", HttpStatus.OK.value());
				return new ResponseEntity<>(response,HttpStatus.OK);
			}
		} catch (Exception e) {
			response.put("Usuario", null);
			response.put("Mensaje", "Ha ocurrido un error");
			response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
			return new ResponseEntity<>(response,HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

}
