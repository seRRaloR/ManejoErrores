package com.jrla.springboot.manejoErrores.app.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jrla.springboot.manejoErrores.app.models.domain.Usuario;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	private List<Usuario> lista;
	
	public UsuarioServiceImpl() {
		this.lista = Arrays.asList(
			 new Usuario(1,"Jose","Lorenzo")
			,new Usuario(2,"Jaca","Paca")
			,new Usuario(3,"Aitor","Tilla")
			,new Usuario(4,"Ester","Nera")
			,new Usuario(5,"Felipe","Pinillos")
			,new Usuario(6,"Paco","Jones")
			,new Usuario(7,"Rosa","Bandija")
				);
	}

	@Override
	public List<Usuario> listar() {
		return this.lista;
	}

	@Override
	public Usuario obtenerPorId(Integer id) {
		Usuario resultado = null;
		
		for (Usuario u: this.lista) {
			if (u.getId().equals(id)) {
				resultado = u;
				break;
			}
		}
		return resultado;
	}

	@Override
	public Optional<Usuario> obtenerPorIdOptional(Integer id) {
		Usuario resultado = this.obtenerPorId(id);
		return Optional.ofNullable(resultado);
	}

}
