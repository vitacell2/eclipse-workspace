package com.mybank.domain;

public class Account {
    
    protected double balance;
    
	// constructor
	/*public Account()
	{
		this.balance = 0;
	}
	*/
    
    protected Account(double initBalance) {
        this.balance = initBalance;
    }
    
    public double getBalance() {
        return this.balance;
    }
    
    public void deposit(double amt) {
        this.balance = this.balance + amt;
    }
    
    public void withdraw(double amt) throws OverdraftException {
        boolean result = false;  // assume operation failure
        if ( amt <= balance ) {
            balance = balance - amt;
        } else {
            throw new OverdraftException("Out of funds, negative balance", amt - balance);
        }
    }
}
