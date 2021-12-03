package com.nttdata.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteController {
	
	@RequestMapping("")
	public String clientes(Model model,HttpSession session ) {
	
		return "cliente.jsp";
	}
	

}
