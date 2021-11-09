package mintic.edu.g33.e4.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import mintic.edu.g33.e4.modelo.Producto;

public interface ProductoRepositorio extends JpaRepository<Producto, Integer> {

}
