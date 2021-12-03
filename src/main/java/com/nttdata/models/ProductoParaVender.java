package com.nttdata.models;

public class ProductoParaVender extends Producto {
    private Float cantidad;

    public ProductoParaVender(String nombre, String codigo, Double precio, Float existencia, Long id, Float cantidad) {
        super();
        this.cantidad = cantidad;
    }

    public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}

	public ProductoParaVender(Float cantidad) {
		super();
		this.cantidad = cantidad;
	}

	public void aumentarCantidad() {
        this.cantidad++;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public Float getTotal() {
        return (float) (this.getPrecio() * this.cantidad);
    }
}