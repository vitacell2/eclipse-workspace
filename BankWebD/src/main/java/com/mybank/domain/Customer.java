package com.mybank.domain;

import java.io.Serializable;
import java.util.Arrays;

public class Customer implements Serializable {

  private String firstName;

  private String lastName;

  private Account[] accounts;
  private int numberOfAccounts;

  public Customer(String f, String l, int numberOfAccounts) {
    firstName = f;
    lastName = l;
    // initialize accounts array
    accounts = new Account[10];
    numberOfAccounts = 0;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void addAccount(Account acct) {
    int i = numberOfAccounts++;
    accounts[i] = acct;
  }

  public int getNumOfAccounts() {
    return numberOfAccounts;
  }

  public Account getAccount(int account_index) {
    return accounts[account_index];
  }

@Override
public String toString() {
	return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", accounts=" + Arrays.toString(accounts)
			+ ", numberOfAccounts=" + numberOfAccounts + "]";
}
  
}
