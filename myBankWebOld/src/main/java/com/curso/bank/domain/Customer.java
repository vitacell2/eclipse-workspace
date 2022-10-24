package com.curso.bank.domain;

import java.io.Serializable;

public class Customer implements Serializable
{
	private String firstName;
	private String lastName;
	private int numOfAccounts;
	private Account[] accounts;

  public Customer(String f, String l, int numberOfAccounts)
  {
    firstName = f;
    lastName = l;
    
    // initialize accounts array
    accounts = new Account[4];
    numOfAccounts = 0; // primero lo ponemos a cero, para inicializar
  }

  // obtener nombre
  public String getFirstName() {
    return firstName;
  }

  // obtener apellido
  public String getLastName() {
    return lastName;
  }

  // añadir cuenta
  public void addAccount(Account acct) {
    int i = numOfAccounts++;
    accounts[i] = acct;
  }

  // obtener numero total de cuentas
  public int getNumOfAccounts() {
    return numOfAccounts;
  }

  // 
  public Account getAccount(int account_index) {
    return accounts[account_index];
  }
}
