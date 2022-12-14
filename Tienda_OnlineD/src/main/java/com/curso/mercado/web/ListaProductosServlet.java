package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.Producto;
import com.curso.mercado.servicios.ProductosService;

/**
 * Servlet implementation class ListaProductosServlet
 */
public class ListaProductosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListaProductosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// recuperar todos los productos
				ProductosService service = new ProductosService();
				List<Producto> lista = service.dameTodosLosProductos();
				System.out.println(lista);
				// añadir el atributo lista con todos los productos  a la request
				request.setAttribute("lista", lista);
				
				// despachar la peticion a lista-productos.jsp
				RequestDispatcher rd = request.getRequestDispatcher("lista-productos.jsp");
				rd.forward(request, response);
	}


}
