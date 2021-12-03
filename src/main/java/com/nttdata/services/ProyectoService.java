package com.nttdata.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nttdata.models.Proyecto;
import com.nttdata.repositories.ProyectoRepository;

@Service
public class ProyectoService {

	@Autowired
	ProyectoRepository pr;

	public List<Proyecto> getAll() {
		return pr.findAll();
	}

	public void save(@Valid Proyecto proyecto) {
		pr.save(proyecto);
	}
	
	public List<Object[]> obtenerProyectosYUsuarios(){
		return pr.obtenerProyectosYUsuarios();
	}
	
}
