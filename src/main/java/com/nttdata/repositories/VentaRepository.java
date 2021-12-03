package com.nttdata.repositories;

import org.springframework.data.repository.CrudRepository;

import com.nttdata.models.Venta;

public interface VentaRepository extends CrudRepository<Venta, Integer> {
	
}