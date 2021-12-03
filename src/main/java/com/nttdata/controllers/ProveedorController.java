package com.nttdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/proveedor")
public class ProveedorController {

	@RequestMapping("")
	public String index() {
		return "proveedor.jsp";
	}
	
	@RequestMapping("/insertar")
	public String insertar(@RequestParam("nombre") String nombre,
			@RequestParam("apellido") String apellido,
			@RequestParam("email") String email,
			@RequestParam("edad") String edad) {
		
		if(edad.isEmpty()) {
			System.out.println("No puede ser vacio");
		}else {
			System.out.println("El nombre es: "+ nombre+" "+apellido);
			System.out.println("Su email es: "+email);
		}
	
		//return "proveedor.jsp";
		return "redirect:/proveedor";
	}
}
