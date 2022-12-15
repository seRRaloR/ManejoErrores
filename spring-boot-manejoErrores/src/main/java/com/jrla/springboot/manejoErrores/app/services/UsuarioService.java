package com.jrla.springboot.manejoErrores.app.services;

import java.util.List;

import com.jrla.springboot.manejoErrores.app.models.domain.Usuario;

public interface UsuarioService {

	public List<Usuario> listar();
	public Usuario obtenerPorId(Integer id);
}
