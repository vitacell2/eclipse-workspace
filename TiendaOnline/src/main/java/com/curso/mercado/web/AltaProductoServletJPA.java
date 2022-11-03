package com.curso.mercado.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.curso.mercado.entidades.ProductoJPA;
import com.curso.mercado.servicios.ProductosServiceJPA;

//@WebServlet(urlPatterns = "altaProductoJPA",loadOnStartup = 4)
public class AltaProductoServletJPA extends HttpServlet
{
	
	private static final long serialVersionUID = 1L;
	
      
	
	//ATRIBUTOS
    ProductosServiceJPA myProductoServiceJPA = new ProductosServiceJPA();
	
    //CONSTRUCTORES
    public AltaProductoServletJPA() {
        super();
        System.out.println(".... instanciando AltaProductoServletJPA");
    	
    }
    
    //METODOS
	protected void doPost(HttpServletRequest request, 
			              HttpServletResponse response) throws ServletException, IOException {
		
	
		
		System.out.println("..... estoy en el doPost. CLASE: AltaProductoServletJPA");
		
		//leer los parametros que recibo en la petición HTTP
		//si el parametro no existe devuelve null
		
		// Cogemos parametros introducidos por el usuario, con "alta-producto-JPA.jsp"
		String paramDescripcion = request.getParameter("descripcion");
		String paramPrecio = request.getParameter("precioUnidad");
		String paramStock = request.getParameter("stock");
		
		//validar parametros
		String msgError = "";
		
		// comprobamos que el nombre del producto no este vacio
		// avisamos del error, si no se introduce nada.
		if(paramDescripcion == null || paramDescripcion.trim().length() == 0 ) {
			msgError = "Debes indicar una descripción para el producto";
		}
		
		// comprobamos que el producto tenga un precio
		double precio = 0.0;
		if(paramPrecio == null || paramPrecio.trim().length() == 0 ) {
			msgError = "Debes indicar un precio para el producto";
		}else {
			// String precio convertimos en un double
			precio = Double.parseDouble(paramPrecio); //falta controlar excepcion
			if (precio == (int)precio) // comprobar que no es un Int, y si es, lo convertimos a Double
			{
				precio = Double.valueOf(precio);
			}
		}
		
		// comprobamos que haya almenos una unidad de un producto que se quiere dar de alta
		int stock = 0;
		if(paramStock == null || paramStock.trim().length() == 0 ) {
			msgError = "Debes dar de alta al menos una unidad de un producto";
		}else {
			// String precio convertimos en un double
			stock = Integer.parseInt(paramStock); //falta controlar excepcion
			if(stock == 0)
			{
				msgError = "No puedes dar de alta 0 productos";
			}
		}
			
		
		//------------
		
		if(msgError.length()>0)
		{
			System.out.println("FALLO: " + msgError);
			
			//despache la pagina alta-producto.jsp
			
			//response.getWriter().append("error "  + msgError);
			
			request.setAttribute("errorBego", msgError);
			
			RequestDispatcher rd = request.getRequestDispatcher("alta-producto-JPA.jsp");
			rd.forward(request, response);
			
			
		}
		else
		{
		
			ProductoJPA p = new ProductoJPA(null, paramDescripcion, precio, stock);
			System.out.println("vamos a dar de alta " + p);
			myProductoServiceJPA.darAltaUnproducto(p);
			
			//response.getWriter().append("ok grabó "  + p);
			//despache la pagina lista-productos.jsp
			
			List<ProductoJPA> listaProductos = myProductoServiceJPA.dameTodosLosProductos();
			
			request.setAttribute("lista", listaProductos);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/vistas/lista-productos.jsp");
			rd.forward(request, response);
			
		}
		
		
		
	
	}//fin doPost

	
	
}
