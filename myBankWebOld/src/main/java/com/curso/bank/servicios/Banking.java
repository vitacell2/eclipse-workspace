package com.curso.bank.servicios;
import com.curso.bank.database.*;

public class Banking {

	
	
	public static void main(String[] args)
	{
        Bank.anadirCliente("Manolo", "Fernandez");
        Bank.anadirCliente("Pablo", "Escobar");
        Bank.anadirCliente("Tom", "Brown");
        Bank.anadirCliente("Maria", "Perez");
        
        for ( int i = 0; i < Bank.getNumeroDeClientes(); i++ )
        {
            Cliente mycliente = Bank.getCliente(i);
            
            System.out.println("Customer [" + (i+1) + "] is "
                    + mycliente.getApellido()
                    + ", " + mycliente.getNombre());
        }
    }

}
