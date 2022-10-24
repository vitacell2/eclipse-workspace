package com.curso.bank.domain;

public class SavingAccount extends Account {
    
    private double bonusRate;
    
    public SavingAccount(double initBalance, double bonusRate)
    {
        super(initBalance);
        this.bonusRate = bonusRate;
    }
    
    public void addBonus()
    {
        balance += (balance * bonusRate);
    }    
}
