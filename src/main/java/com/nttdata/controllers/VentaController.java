package com.nttdata.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nttdata.models.Producto;
import com.nttdata.models.ProductoParaVender;
import com.nttdata.repositories.ProductoRepository;
import com.nttdata.repositories.VentaRepository;

public class VentaController {

	@Autowired
	ProductoRepository productoRepository;
	
	@Autowired
    VentaRepository ventaRepository;
	
	@GetMapping(value = "/vender")
	public String interfazVender(Model model, HttpServletRequest request) {
	    model.addAttribute("producto", new Producto());
	    float total = 0;
	    ArrayList<ProductoParaVender> carrito = this.obtenerCarrito(request);
	    for (ProductoParaVender p: carrito) total += p.getTotal();
	    model.addAttribute("total", total);
	    return "vender/vender";
	}

	private ArrayList<ProductoParaVender> obtenerCarrito(HttpServletRequest request) {
		
		return null;
	}
	
	@GetMapping(value = "/")
    public String mostrarVentas(Model model) {
        model.addAttribute("ventas", ventaRepository.findAll());
        return "ventas/ver_ventas";
    }
	
	@PostMapping(value = "/agregar")
	public String agregarAlCarrito(@ModelAttribute Producto producto, HttpServletRequest request, RedirectAttributes redirectAttrs) {
	    ArrayList<ProductoParaVender> carrito = this.obtenerCarrito(request);
	    Producto productoBuscadoPorCodigo = productoRepository.findFirstByCodigo(producto.getCodigo());
	    if (productoBuscadoPorCodigo == null) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto con el código " + producto.getCodigo() + " no existe")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/vender/";
	    }
	    if (productoBuscadoPorCodigo.sinExistencia()) {
	        redirectAttrs
	                .addFlashAttribute("mensaje", "El producto está agotado")
	                .addFlashAttribute("clase", "warning");
	        return "redirect:/vender/";
	    }
	    boolean encontrado = false;
	    for (ProductoParaVender productoParaVenderActual : carrito) {
	        if (productoParaVenderActual.getCodigo().equals(productoBuscadoPorCodigo.getCodigo())) {
	            productoParaVenderActual.aumentarCantidad();
	            encontrado = true;
	            break;
	        }
	    }
	    if (!encontrado) {
	        carrito.add(new ProductoParaVender(productoBuscadoPorCodigo.getNombre(), productoBuscadoPorCodigo.getCodigo(), productoBuscadoPorCodigo.getPrecio(), productoBuscadoPorCodigo.getExistencia(), productoBuscadoPorCodigo.getId(), 1f));
	    }
	    this.guardarCarrito(carrito, request);
	    return "redirect:/vender/";
	}
	
	@PostMapping(value = "/quitar/{indice}")
	public String quitarDelCarrito(@PathVariable int indice, HttpServletRequest request) {
	    ArrayList<ProductoParaVender> carrito = this.obtenerCarrito(request);
	    if (carrito != null && carrito.size() > 0 && carrito.get(indice) != null) {
	        carrito.remove(indice);
	        this.guardarCarrito(carrito, request);
	    }
	    return "redirect:/vender/";
	}
	
	private ArrayList<ProductoParaVender> obtenerCarrito1(HttpServletRequest request) {
	    ArrayList<ProductoParaVender> carrito = (ArrayList<ProductoParaVender>) request.getSession().getAttribute("carrito");
	    if (carrito == null) {
	        carrito = new ArrayList<>();
	    }
	    return carrito;
	}
	
	

	private void guardarCarrito(ArrayList<ProductoParaVender> carrito, HttpServletRequest request) {
	    request.getSession().setAttribute("carrito", carrito);
	}
}
