package com.curso.bank.domain;

public class Account {
    
    protected double balance; // saldo
    protected double deposit; // ingreso
    protected double withdraw; // retiro
    
    protected Account(double initBalance)
    {
        balance = initBalance; // saldo igual a saldo de partida
    }
    
    public double getBalance() // obtener saldo
    {
        return balance; // devolver saldo
    }
    
	public void setBalance(double bal) {
		//depositarSaldo();
		this.balance = bal;
	}
    
    public boolean deposit(boolean dep) // añadir fondos
    {
        //balance = balance + deposit; // añadir saldo a la cuenta
        dep = false;
    	
		if (deposit > 0)
		{
			this.balance = balance + deposit;
			System.out.printf("Se han añadido %f ", deposit);
			return true;
		}
		else 
		{
			throw new RuntimeException("No hay dinero que depositar");
			//return false;
		}
		//return true;
    }
    
    
    public boolean withdraw(double wdBalance) throws OverdraftException
    {
		boolean seRetira = false;
		if (withdraw <= balance)
		{
			this.balance = balance - wdBalance;
			seRetira = true;
			setBalance(balance);
			//return true;
		}else
		{
			seRetira = false;
			throw new RuntimeException("No se puede retirar mas de lo que se tiene");
			//return false;
		}
		return seRetira;
    	
        /*boolean output = false;  // falso, a menos que:
        
        if ( wdBalance <= balance )
        {
            balance = balance - wdBalance;
        }
        else
        {
            throw new OverdraftException("Out of funds, negative balance", wdBalance - balance);
        }*/
    }
}
