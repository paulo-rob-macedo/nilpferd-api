package com.denkenvoncode.nilpferdapi.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.denkenvoncode.nilpferdapi.security.UsuarioLogin;

public class UsuarioLoginService {

	public static UsuarioLogin authenticated() {
		try {
			return (UsuarioLogin) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch (Exception e) {
			return null;
		}
	}
}
