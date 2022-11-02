package com.curso.mercado.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.curso.mercado.entidades.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(urlPatterns="login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	//contexto de la aplicación
    	// CREO UN ATRIBUTO DE ÁMBITO DE APLICACIÓN
    	// es para todos los usuarios en todas las pagínas/Servlets/jsp
    	System.out.println("..... " + config.getServletContext());
    	config.getServletContext().setAttribute("tituloTienda", "EL ALMACEN");
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = request.getParameter("nombre");
		String rol = request.getParameter("rol");
		
		String msgError = "";
		
		if(usuario == null || usuario.trim().length() == 0) {
			msgError = "Debes introducir un nombre de usuario";
		}
		
		if(rol == null || !rol.equals("admin") && !rol.equals("usuario")) {
			msgError = "Debes seleccionar tu rol";
		}
		
		if(msgError.length()>0) {
			request.setAttribute("error", msgError);
			
			RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
			rd.forward(request, response);
		}else {
			//creo un objeto  por defecto sol esta diponible doPost
			
			Usuario u = new Usuario(usuario, rol);
			
			//modo 1. ÁMBITO DE PETICIÓN (REQUEST)
			//objeto usuario ahora lo asigno como un atributo de la peticion
			//solo esta disponble durante el tiempo que dure la petición
		
		//	request.setAttribute("usuario", usuario);	
			
			//sin rd  una vez terminado el doPost finaliza la petición
			//se envía la respuesta al navegador
			//response.getWriter().append("usuario " + usuario.getNombre());
			
			//despacho la petición a un jsp y le envio en atributo
			//colgando de la request
			
		//	RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		//	rd.forward(request, response);


			//modo 2. ÁMBITO DE SESIÓN (MEJOR)
			
			// getSession obtiene la httpsession del usuario si existe
			//            y sino la crea y me la devuelve
			HttpSession sesion= request.getSession();
			//sesion.isNew()
			//sesion.invalidate();
			//sesion.setMaxInactiveInterval(0); //segundos
			
			sesion.setAttribute("usuario", u);
				
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		
		}
		
	}

}
