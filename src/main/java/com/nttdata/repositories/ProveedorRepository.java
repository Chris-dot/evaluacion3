package com.nttdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nttdata.models.Proveedor;

@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long>{
	
	

}
