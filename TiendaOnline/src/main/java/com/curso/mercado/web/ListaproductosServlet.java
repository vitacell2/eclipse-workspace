package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductosService;

/**
 * Servlet implementation class ListaproductosServlet
 */
public class ListaproductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public ListaproductosServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// recuperar todos los productos
		ProductosService myService = new ProductosService();
		List<Producto> myLista = myService.dameTodosLosProductos();
		
		// añadir el atributo lista con todos los productos a la request
		request.setAttribute("lista", myLista); 
		// .getAttributes atributos del objeto
		// .getParameters es para los atributos de datos que viajan segun la peticion
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
