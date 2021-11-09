package mintic.edu.g33.e4.repositorio;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import mintic.edu.g33.e4.modelo.Usuario;

public interface IUsuario extends CrudRepository<Usuario, Long>{
	
	@Query("select count(*) from Usuario as p where p.nombreUsuario=:nombreUsuario and p.psswrd=:psswrd")
	Integer findByNombreUsuarioAndPassword( @Param("nombreUsuario") String nombreUsuario,
								@Param("psswrd") String psswrd);
	
	@Query("select p from Usuario as p where p.nombreUsuario=:nombreUsuario and p.psswrd=:psswrd")
	Usuario findByNombreAndPassword( @Param("nombreUsuario") String nombreUsuario,
								@Param("psswrd") String psswrd);
	
}
