package com.denkenvoncode.nilpferdapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.denkenvoncode.nilpferdapi.domain.Usuario;
import com.denkenvoncode.nilpferdapi.repositories.UsuarioRepository;
import com.denkenvoncode.nilpferdapi.security.UsuarioLoginAuthenticated;

public class UsuarioLoginServiceImpl implements UserDetailsService {

	@Autowired
	private UsuarioRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Usuario usuario=repository.findByEmail(email);
		if (usuario == null) {
			throw new UsernameNotFoundException(email);
		}
		return new UsuarioLoginAuthenticated(usuario.getId(), usuario.getEmail(), usuario.getSenha(), usuario.getPerfis());
	}
}
