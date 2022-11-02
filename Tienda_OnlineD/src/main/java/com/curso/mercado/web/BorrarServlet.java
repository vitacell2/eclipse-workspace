package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.servicios.ProductosService;

/**
 * Servlet implementation class BorrarServlet
 */
public class BorrarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BorrarServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String paramId=request.getParameter("idProducto");
		
		int idProducto = 0;
		if(paramId!=null) {
			idProducto = Integer.parseInt(paramId);
		}
		ProductosService service = new ProductosService();
		
		service.borrarProducto(idProducto);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaProductos");
		rd.forward(request, response);
	}

}
