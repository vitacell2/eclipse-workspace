package com.curso.Proy004_maquina_expendedora;

public class Maquina {

	//variables primitivas
	public int refrescos;
	public int centimos;
	public boolean compra;
	public double efectivo;
	
	//constructor
	public Maquina(int refrescos, 
		      int centimos,
		      boolean compra, 
		      double fectivo)
	{
		super();
		this.refrescos = 34;
		this.centimos = 1500;
		this.compra = false;
		this.efectivo = 0.0;
	}
	
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
		testStock();
		comprobarEfectivo();
		getRefrescoInfo();
		
		
		
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
	
	public void getRefrescoInfo()
	{
		
	}
	
	public void testStock()
	{
		
	}
}
