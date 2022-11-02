package com.curso.mercado.entidades;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity // son para saber como montar los JQuery
@Table (name = "PRODUCTOS", schema = "HR")

public class ProductoJPA implements Serializable{
	
	/*
	 * indica la version de la clase
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	// ATRIBUTOS
	@Id
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUCTOS_SEQ")
	//@SequenceGenerator(sequenceName = "PRODUCTOS_SEQ", name = "PRODUCTOS_SEQ", allocationSize=1)
	@Column (name = "ID_PRODUCTO")
	private Integer idProducto;
	@Column (name = "DESCRIPCION")
	private String descripcion;
	@Column (name = "PRECIO")
	private double precio;
	@Column (name = "STOCK")
	private int stock;
	
	@Transient
	private boolean isSelected;
	
	
	
	// CONSTRUCTORES
	public ProductoJPA() {
		super();
	}

	public ProductoJPA(Integer idProducto, String descripcion, double precio, int stock) {
		super();
		this.idProducto = idProducto;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
	}


	
	public Integer getIdProducto() {
		return idProducto;
	}


	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}

	
	public int getStock() {
		return stock;
	}
	
	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [idProducto=" + idProducto + ", descripcion=" + descripcion + ", precio=" + precio + ", stock=" + stock + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(idProducto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoJPA other = (ProductoJPA) obj;
		return Objects.equals(idProducto, other.idProducto);
	}
	
	
	

}
