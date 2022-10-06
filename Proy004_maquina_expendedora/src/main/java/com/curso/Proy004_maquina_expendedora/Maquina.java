package com.curso.Proy004_maquina_expendedora;

public class Maquina {

	//variables primitivas
	public int refrescos;
	public int centimos;
	public boolean compra;
	public double efectivo;
	
	//constructor
	
	
	//metodos
	public void reponerRefresco() //reponer
	{
		
		this.refrescos++;			
	}
	
	public void convertirEuros (double euros, int centimos)
	{
		double eur = euros;
		int cent = (int) euros;
		this.centimos = this.centimos + cent;	
	}
	
	public void comprar() //cuando se pulsa el boton para ralizar la comprar
	{
		comprobarEfectivo();
		this.refrescos--;
		
	}
	
	public void comprobarEfectivo()
	{
		
		convertirEuros(eur, centimos);
		if(centimos > 0 && efectivo > 0)
		{
			if()
		}
		else
		{
			
		}
	}
	
	public void devolverEuros()
	{
		
	}
}
