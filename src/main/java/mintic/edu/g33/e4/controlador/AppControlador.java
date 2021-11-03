package mintic.edu.g33.e4.controlador;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import mintic.edu.g33.e4.modelo.Productos;
import mintic.edu.g33.e4.servicio.ProductoServicio;

@Controller
public class AppControlador {
	
	@Autowired
	private ProductoServicio servicio;
	
	//Listado de Productos
	@RequestMapping("/")
	public String verIndex(Model model) {
		List<Productos> listaProductos = servicio.listar();
		model.addAttribute("listaProductos", listaProductos);
		return "index";
	}
	
	//Vista nuevo Producto
	@RequestMapping("/new")
	public String mostrarPaginaProducto(Model model){
		Productos producto = new Productos();
		model.addAttribute("producto", producto);
		
		return "nuevo_producto";
	}
	
	//Crear nuevo Producto
	@PostMapping("/save")
	public String saveProducto(@Valid @ModelAttribute("producto") Productos producto, Errors errores,Model model) {
		
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
