package mintic.edu.g33.e4.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mintic.edu.g33.e4.modelo.ProductoRepositorio;
import mintic.edu.g33.e4.modelo.Productos;

/*
 * Servicio de Producto
 * 
 * Funciones: 
 * lista, editar, crear, eliminar 
 * 
 */

@Service
@Transactional
public class ProductoServicio {
	@Autowired
	private ProductoRepositorio repo;

	public List<Productos> consultarListaProducto(){
		return repo.findAll();
	}

	public Productos consultarProducto(int cod) {
		return repo.findById(cod).get();
	}

	public void editarProducto(Productos pro) {
		repo.save(pro);
	}

	public void eliminarProducto(int cod) {
		repo.deleteById(cod);
	}
}
