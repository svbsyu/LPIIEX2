package com.cibertec.app.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cibertec.app.entity.Usuario;
import com.cibertec.app.repository.UsuarioRepository;
import com.cibertec.app.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	private UsuarioRepository usuarioRepositorio;
	
	public UsuarioServiceImpl(UsuarioRepository usuarioRepositorio) {
		super();
		this.usuarioRepositorio = usuarioRepositorio;
	}

	@Override
	public Usuario saveUsuario(Usuario objUsuario) {
		Usuario usuario = new Usuario(objUsuario.getNombres(),objUsuario.getApellidos(),
				objUsuario.getUsername(),objUsuario.getClave(), objUsuario.getRol()) ;
				
		return usuarioRepositorio.save(usuario);
	}

	@Override
	public List<Usuario> getAllUsuario() {
		return usuarioRepositorio.findAll();
	}

	@Override
	public boolean login(Usuario usuario) {
		boolean band;
		// TODO Auto-generated method stub		
		Usuario entidad=usuarioRepositorio.findByUsuarioAndClave(usuario.getUsername(), 
																	usuario.getClave());
		System.out.println("usuario.getUsername()--> "+usuario.getUsername());
		System.out.println("usuario.getClave()--> "+usuario.getClave());
		
		if(entidad==null) {
			band=false;
		}else {
			band=true;
		}		
		return band;
	}
}
