package com.jrla.springboot.manejoErrores.app.controllers;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jrla.springboot.manejoErrores.app.errors.UsuarioNoEncontradoException;

// La siguiente anotación es importante
@ControllerAdvice
public class ErrorHandlerController {

	// Se podrían capturar más tipos de excepciones:
	// @ExceptionHandler({ArithmeticException.class, OtroTipoDeExcepcion.class})
	@ExceptionHandler(ArithmeticException.class)
	public String aritmeticaError (Exception ex, Model modelo) {
	// Se podría concretar más el tipo de excepción:
	//	public String aritmeticaError (AritmeticException ex, Model modelo) {
		modelo.addAttribute("error", "Error aritmético");
		modelo.addAttribute("mensaje", ex.getMessage());
		modelo.addAttribute("codigo", HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp", new Date());
		
		return "error/generica";
	}
	
	@ExceptionHandler(NumberFormatException.class)
	public String errorFormatoNumerico(NumberFormatException ex, Model modelo) {
		modelo.addAttribute("error", "Error de formato numérico");
		modelo.addAttribute("mensaje", ex.getMessage());
		modelo.addAttribute("codigo", HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp", new Date());
		
	
		return("error/generica");
	}
	
	@ExceptionHandler(UsuarioNoEncontradoException.class)
	public String usuarioNoEncontrado(UsuarioNoEncontradoException ex, Model modelo) {
		modelo.addAttribute("error", "ERROR: usuario no encontrado!!!!");
		modelo.addAttribute("mensaje", ex.getMessage());
		modelo.addAttribute("codigo", HttpStatus.INTERNAL_SERVER_ERROR.value());
		modelo.addAttribute("timestamp", new Date());
		
	
		return("error/generica");
	}
}
