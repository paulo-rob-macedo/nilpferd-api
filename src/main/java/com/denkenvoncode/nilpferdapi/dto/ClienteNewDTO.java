package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.services.validation.ClienteNew;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@ClienteNew
public class ClienteNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String nome;
	
	@Getter
	@Setter
	private String email;
	
	@Getter
	@Setter
	private String numdoc;
	
	@Getter
	@Setter
	private String logradouro;
	
	@Getter
	@Setter
	private String numero;
	
	@Getter
	@Setter
	private String complemento;
	
	@Getter
	@Setter
	private String bairro;
	
	@Getter
	@Setter
	private String cidade;
	
	@Getter
	@Setter
	private String uf;
	
	@Getter
	@Setter
	private String cep;
	
	@Getter
	@Setter
	private String fone;
}
