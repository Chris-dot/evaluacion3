package com.nttdata.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre;
	private String codigo;
	private String descripcion;
	private Double precio;
	private Float existencia;
	private Float cantidad;
	@Column(updatable = false)
	private Date createdAt;
	private Date updatedAt;
	
	//relacion many to many
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name="categorias_productos",//tabla intermedia
		joinColumns = @JoinColumn(name="producto_id"),
		inverseJoinColumns = @JoinColumn(name="categoria_id")
	)
	private List<Categoria> categorias;

	
	public Producto() {
		super();
	}
	
	
	public Producto(Long id, String nombre, String codigo, String descripcion, Double precio, Float existencia,
			Float cantidad, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.existencia = existencia;
		this.cantidad = cantidad;
		this.categorias = categorias;
	}
	
	
	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", codigo=" + codigo + ", descripcion=" + descripcion
				+ ", precio=" + precio + ", existencia=" + existencia + ", cantidad=" + cantidad + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + ", categorias=" + categorias + "]";
	}


	
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public Float getExistencia() {
		return existencia;
	}


	public void setExistencia(Float existencia) {
		this.existencia = existencia;
	}


	public Float getCantidad() {
		return cantidad;
	}


	public void setCantidad(Float cantidad) {
		this.cantidad = cantidad;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

	public String getCodigo() {
		// TODO Auto-generated method stub
		return null;
	}


	public Float getTotal() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
