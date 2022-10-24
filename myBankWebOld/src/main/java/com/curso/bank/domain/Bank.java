package com.curso.bank.domain;

public class Bank {
  private static Customer[] customers;
  private static int numOfCustomers;

  static
  {
    customers = new Customer[4]; // 5 clientes
    
    Customer customer0 = new Customer("Sancho", "Panza",0);
    customer0.addAccount (new SavingAccount(100, 0.5));
    customer0.addAccount (new SavingAccount(100, 0.5));
    
    Customer customer1 = new Customer("Federico", "Lorza",0);
    customer1.addAccount (new SavingAccount(150, 0.1));
    customer1.addAccount (new SavingAccount(150, 0.1));
    
    Customer customer2 = new Customer("Manolo", "Marcos",0);
    customer2.addAccount (new SavingAccount(350, 0.9));
    customer2.addAccount (new SavingAccount(350, 0.9));
    
    Customer customer3 = new Customer("Pocho", "Huevon",0);
    customer3.addAccount (new SavingAccount(270, 0.2));
    customer3.addAccount (new SavingAccount(270, 0.2));
    
    //Customer customer4 = new Customer("Paco", "Fuentes",0);
    //customer4.addAccount (new SavingAccount(580, 0.4));
    //customer4.addAccount (new SavingAccount(580, 0.4));
    
    customers[0] = customer0;
    customers[1] = customer1;
    customers[2] = customer2;
    customers[3] = customer3;
    //customers[4] = customer4;
    
    numOfCustomers = 4;
  }

  public static int getNumOfCustomers()
  {
    return numOfCustomers;
  }
  
  public static Customer getCustomer(int customer_index)
  {
    return customers [customer_index];
  }
  
  public static Customer[] getCustomers()
  {
	  return customers;
  }
  
  public static void addCustomer(String f, String l)
  {
    int i = numOfCustomers + 1;
    customers[i] = new Customer(f, l,0);
  }
  
}
