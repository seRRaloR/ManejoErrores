package com.jrla.springboot.manejoErrores.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AppController {
	
	
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index(Model modelo) {
		
		//Integer valor = Integer.parseInt("ValorNoNumérico");
		Integer valor = 100 / 0;
		return "index";
	}

}
