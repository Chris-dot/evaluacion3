package com.nttdata.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.models.Producto;

public interface ProductoRepository extends CrudRepository<Producto, Long>{
	
	Producto findFirstByCodigo(String codigo);

	Optional<Producto> findById(int id);
}
