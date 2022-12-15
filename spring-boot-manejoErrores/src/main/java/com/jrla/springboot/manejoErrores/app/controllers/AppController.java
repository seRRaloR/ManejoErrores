package com.jrla.springboot.manejoErrores.app.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.jrla.springboot.manejoErrores.app.errors.UsuarioNoEncontradoException;
import com.jrla.springboot.manejoErrores.app.models.domain.Usuario;
import com.jrla.springboot.manejoErrores.app.services.UsuarioService;

@Controller
public class AppController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@SuppressWarnings("unused")
	@GetMapping("/index")
	public String index(Model modelo) {
		
		//Integer valor = Integer.parseInt("ValorNoNumérico");
		Integer valor = 100 / 0;
		return "index";
	}
	
	@GetMapping("/ver/{id}")
	public String ver(@PathVariable Integer id, Model modelo) {
		Usuario usuario = usuarioService.obtenerPorId(id);
		
		if (usuario == null) {
			throw new UsuarioNoEncontradoException(id.toString());
		}
		
		modelo.addAttribute("usuario", usuario);
		modelo.addAttribute("titulo", "Detalle usuario: ".concat(usuario.getNombre()));
		return "ver";
	}

}
