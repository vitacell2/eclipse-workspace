package com.curso.jpa.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ORDERS")

public class Order implements Serializable
{
	// ATRIBUOS
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CUST_SEQ")
	@SequenceGenerator(sequenceName = "EMPLOYEES_SEQ", name = "CUST_SEQ", allocationSize=1)
	private Long orderId;
	
	@Column (name = "DESCRIPTION")
	private String descripcion;
	
	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", descripcion=" + descripcion + ", idCliente=" + idCliente + "]";
	}

	@Column (name = "CUSTOMER_ID")
	private Long idCliente;
	
	@JoinColumn (name = "CUSTOMER_ID", referencedColumnName = "ID") // referencedColumnName es 
							// la referencia, de como se llama la columna en la base de datos
	private Customer myCliente;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Long getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public Customer getCliente() {
		return myCliente;
	}

	public void setCliente(Customer cliente) {
		this.myCliente = cliente;
	}
}
