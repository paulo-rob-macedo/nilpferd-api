package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.denkenvoncode.nilpferdapi.domain.Usuario;
import com.denkenvoncode.nilpferdapi.services.validation.UsuarioNew;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@UsuarioNew
public class UsuarioNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "Defina o nome do usuario!")
	@Size(min=1, max=100,message="Nome deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	private String nome;
	
	@NotBlank(message = "Defina o apelido do usuario!")
	@Size(min=1, max=50,message="Apelido deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	private String apelido;
	
	@NotBlank(message = "Defina o email do usuario!")
	@Size(min=1, max=200,message="Email deve ter {min} a {max} caracteres!")
	@Email(message = "Informe o email corretamente!")	
	@Getter
	@Setter
	private String email;
	
	@NotBlank(message = "Defina a senha do usuario!")
	@Size(min=1, max=200,message="Senha deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	private String senha;	
	
	public UsuarioNewDTO(Usuario usuario) {
		this.nome=usuario.getNome();
		this.apelido=usuario.getApelido();
		this.email=usuario.getEmail();
		this.senha=usuario.getSenha();
	}
}
