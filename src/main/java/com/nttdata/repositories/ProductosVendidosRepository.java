package com.nttdata.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.models.Producto;

public interface ProductosVendidosRepository extends CrudRepository<Producto, Long> {
	
}
