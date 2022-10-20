package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.servicios.VentasService;
import com.curso.mercado.servicios.excepciones.VentasException;

@WebServlet(urlPatterns = "comprar")
public class VentasSerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public VentasSerlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//leer parametro que recibe el idProducto
		// comprar un producto
		String paramId = request.getParameter("idProducto");
		String paramCantidad = request.getParameter("cantidad");
		
		int idProductoComprar = 0;
		if(paramId != null)
		{
			idProductoComprar = Integer.parseInt(paramId); // falta controlar excepcion
		}
		
		int cantidad = 1;
		if(paramCantidad !=null)
		{
			cantidad = Integer.parseInt(paramCantidad);
		}
		
		// comprar una unidad
		VentasService myServicio = new VentasService();
		String myMensaje = "";
		try
		{
			myServicio.comprarProducto(idProductoComprar, 1);
			// compra OK
			// volver a la lista
			myMensaje = "Has comprado una unidad";
			
		}catch (VentasException e) 
		{
			// crear un atributo msgError que indique que ha pasado
			myMensaje = "No se ha comprado. " + e.getMessage();
		}
		
		request.setAttribute("mensaje", myMensaje);
		
		// llamar a la lista de productos directamente
		//RequestDispatcher rd = request.getRequestDispatcher("lista-productos.jsp");
		
		// despacho la peticion a ListaProductosServlet que
		// esta se encarga de obtener lista y despachar a la pagina JSP lista-productos.jsp
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/listaProducos");
		rd.forward(request,response);
		
	}

	
}
