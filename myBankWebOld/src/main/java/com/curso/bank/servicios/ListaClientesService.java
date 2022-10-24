package com.curso.bank.servicios;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.bank.database.*;
import com.curso.bank.servicios.*;
import com.curso.bank.domain.Customer;
import com.curso.bank.web.*;

public class ListaClientesService extends HttpServlet
{
	private static final long serialVersionUID = 1L;   

    public ListaClientesService() {
        super();
        // TODO Auto-generated constructor stub
    }

    // metodo GET
	  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	  { 
		ClientesService service = new ClientesService();
		Customer[] customers = service.getAllClients();
		//System.out.println(customers.toString());
		request.setAttribute("lista", customers);
			
		RequestDispatcher rd = request.getRequestDispatcher("clients-list.jsp");
		rd.forward(request, response);
	/*
		ListaClientesService lcs = new ListaClientesService();
		List<Customer> lc = lcs.getAllClients();
		
		request.setAttribute("lista", lc);
		
		//llamar
		RequestDispatcher rd  = request.getRequestDispatcher("lista-clientes.jsp");
		rd.forward(request, response);*/
		  
	  }
	  
	  // metodo POST
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
		{
			doGet(request, response);
		}

}
