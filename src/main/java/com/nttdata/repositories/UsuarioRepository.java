package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	Usuario findByEmail(String email);
	
	Usuario findByNombre(String nombre);
	
	List<Usuario> findAll();
	
	@Query("SELECT u FROM Usuario u")
	List<Usuario> findAllUsuarios();
	
	@Query("SELECT u.nombre FROM Usuario u")
	List<String> findAllUsuariosNombres();
	
	@Query("SELECT u.nombre, u.apellido FROM Usuario u")
	List<Object[]> findAllUsuariosNombreApellido();
	
	@Query("SELECT u FROM Usuario u Where id = ?1")
	List<Usuario> obtenerUsuarioWhereId(Long id);
	
	//Query tradicional (se agregar nombre de la tabla, NO el objeto)
	@Query(value = "SELECT nombre, apellido FROM usuarios", nativeQuery = true)
	List<Object[]> findAllUsuariosNombreApellidoSQL();
	
	@Query(value= "SELECT * FROM usuarios Where rut = ?2 and id = ?1", nativeQuery = true)
	List<Usuario> obtenerUsuarioWhereIdSQL(Long id, String rut);
}
