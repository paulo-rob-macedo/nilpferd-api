package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import com.denkenvoncode.nilpferdapi.services.validation.UsuarioUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@UsuarioUpdate
public class UsuarioUpdDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private String apelido;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String senha;	
	
	@Getter
	@Setter
	private Integer statusid;	
	
}
