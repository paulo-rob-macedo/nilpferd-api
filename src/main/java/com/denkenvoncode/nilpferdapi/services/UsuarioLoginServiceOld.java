package com.denkenvoncode.nilpferdapi.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.denkenvoncode.nilpferdapi.security.UsuarioLoginAuthenticated;

public class UsuarioLoginServiceOld {

	public static UsuarioLoginAuthenticated authenticated() {
		try {
			return (UsuarioLoginAuthenticated) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
