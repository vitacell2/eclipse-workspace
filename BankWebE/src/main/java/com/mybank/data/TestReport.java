package com.mybank.data;

import com.mybank.domain.*;
import com.mybank.report.*;
import com.mybank.data.DataSource;
import java.io.IOException;

public class TestReport {

  public static void main(String[] args) {

  
      String dataFilePath = "data/test.dat";

      try {
	System.out.println("Reading data file: " + dataFilePath);
	// Create the data source and load the Bank data
	DataSource dataSource = new DataSource(dataFilePath);
	dataSource.loadData();

	// Run the customer report
	CustomerReport report = new CustomerReport();
	report.generateReport();

      } catch (IOException ioe) {
	System.out.println("Could not load the data file.");
	System.out.println(ioe.getMessage());
	ioe.printStackTrace(System.err);
      }
    
  }
}
