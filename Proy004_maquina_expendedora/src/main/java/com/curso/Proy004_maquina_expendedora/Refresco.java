package com.curso.Proy004_maquina_expendedora;

public class Refresco {

	// atributos
	public String sabor;
	private int tamano;
	private double precio;
	private boolean agotado;
	private short stock;
	
	//constructor, creamos objeto
	public Refresco(String sabor, 
		      int tamano,
		      double precio, 
		      boolean agotado, 
		      short stock) {
	 super(); // la primera inst super() 
	   // llamar al constructor del padre  lo ponga o no, en este caso llama a la clase padre "Object"
	this.sabor = "Naranja";
	this.tamano = 400;
	this.precio = 0.75;
	this.agotado = false;
	this.stock = 15;
}
	
	public String getSabor() {
		return sabor;
	}
	public void setSabor(String sabor) {
		this.sabor = sabor;
	}
	public int getTamano() {
		return tamano;
	}
	public void setTamano(int tamano) {
		this.tamano = tamano;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public short getStock() {
		return stock;
	}
	public void setStock(short stock) {
		this.stock = stock;
	}
	
	
	
}
