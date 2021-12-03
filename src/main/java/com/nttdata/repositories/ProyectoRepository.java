package com.nttdata.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Proyecto;

@Repository
public interface ProyectoRepository extends CrudRepository<Proyecto, Long> {

	List<Proyecto> findAll();
	
	//obteniendo todos los proyectos
	@Query("SELECT p FROM Proyecto p JOIN p.usuarios u")
	List<Proyecto> obtenerProyectosJoinUsuarios();
	
	//obteniendo todos los proyectos y usuarios
	@Query("SELECT p, u FROM Proyecto p JOIN p.usuarios u")
	List<Object[]> obtenerProyectosYUsuarios();
}
