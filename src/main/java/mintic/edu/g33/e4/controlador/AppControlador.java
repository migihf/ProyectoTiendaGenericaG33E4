package mintic.edu.g33.e4.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import mintic.edu.g33.e4.cliente.IClientTienda;
import mintic.edu.g33.e4.modelo.Login;
import mintic.edu.g33.e4.modelo.Producto;
import mintic.edu.g33.e4.repositorio.ITipoDocumento;
import mintic.edu.g33.e4.servicio.IUsuarioServicio;
import mintic.edu.g33.e4.servicio.ProductoServicio;

@Controller
public class AppControlador {
	
	@Autowired
	private ProductoServicio servicio;
	
	@Autowired
	IClientTienda clienteTienda;
	
	@Autowired
	IUsuarioServicio iUsuario;
	
	@Autowired
	ITipoDocumento iTipoDocumento;
	
	@CrossOrigin(origins= {"http://localhost:8080/tiendagenerica/v1"})
	@PostMapping("loginclient")
	public int login(@RequestBody Login usuario) {
		int responseLogin=iUsuario.login(usuario);
		return responseLogin;
	}
	
	@PostMapping("/login")
	public ResponseEntity<?> loginCliente(@RequestBody Login usuario){
		return iUsuario.ingresar(usuario);
	}

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/menu")
	public String menu() {
		return "menu";
	}
	
	//Index
	@RequestMapping("/")
	public String verIndex() {
		
		return "index";
		
	}
	
	@PostMapping("/")
	public String login(Model model, Login login) {
		
		int validLogin=clienteTienda.login(login);
		
		if (validLogin==1) {
			return "menu";
		} else {
			model.addAttribute("error","Usuario o contraseña invalidos");
			return "index";
		}
	}
	
	//Menu
	@RequestMapping("/menu")
	public String verMenu() {
		
		return "menu";
		
	}
	
	//Listado de Productos
	@RequestMapping("/products")
	public String verProductos(Model model) {

		List<Producto> listaProductos = servicio.listar();
		model.addAttribute("listaProductos", listaProductos);
		
		return "productos";
		
	}
	
	
	//Vista nuevo Producto
	@RequestMapping("/new")
	public String paginaNuevoProducto(Model model){
		
		Producto producto = new Producto();
		model.addAttribute("producto", producto);
		
		return "nuevo_producto";
		
	}
	
	//Crear nuevo Producto
	@PostMapping("/save")
	public String saveProducto(@Valid @ModelAttribute("producto") Producto producto, Errors errores,Model model) {
		
		if (errores.hasErrors()) {
			
			return "nuevo_producto";
			
		} else {
			servicio.save(producto);
			
			return "redirect:/";
			
		}
		
	}
	
	//Consultar Producto por codigo
	@GetMapping("/listar/{codigo_producto}")
	public String listarId(@PathVariable int codigo, Model model) {
		
		model.addAttribute("producto", servicio.listarId(codigo));
		
		return "editar_producto";
		
	}
	
	//Eliminar Producto por codigo
	@RequestMapping("/delete/{codigo_producto}")
	public String deleteProduct(@PathVariable(name="codigo_producto") int codigo){
		
		servicio.delete(codigo);
		
		return "redirect:/";
		
	}
	
}
