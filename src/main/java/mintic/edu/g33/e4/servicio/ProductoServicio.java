package mintic.edu.g33.e4.servicio;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mintic.edu.g33.e4.repositorio.ProductoRepositorio;
import mintic.edu.g33.e4.modelo.Producto;

@Service
@Transactional
public class ProductoServicio {
	
	@Autowired
	private ProductoRepositorio repo;
	
	//Listado de Productos
	public List<Producto> listar(){
		return repo.findAll();
	}
	
	//Consultar Producto por codigo
	public Producto listarId(int id) {
		return repo.findById(id).get();
	}
	
	//Guardar datos de Producto
	public void save(Producto p) {
		repo.save(p);
	}
	
	//Eliminar Producto
	public void delete(int d) {
		repo.deleteById(d);
	}
	
}
