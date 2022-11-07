package com.curso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/",method = RequestMethod.GET)
	public String saludar(Model model) {
		model.addAttribute("saludo", "Bienvenido a nuestra tienda online!");
		model.addAttribute("linea1", "Los mejores productos ");
		return "inicio";
	}
	
}
