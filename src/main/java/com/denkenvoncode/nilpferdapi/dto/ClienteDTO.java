package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.services.validation.ClienteUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ClienteUpdate
public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include()
	@Getter
	@Setter
	private Long id;
	
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
	private String status;
	
	public ClienteDTO(Cliente cliente) {
		this.id=cliente.getId();
		this.nome=cliente.getNome();
		this.email=cliente.getEmail();
		this.numdoc=cliente.getNumdoc();
		this.status=cliente.getStatus().getDescr();
	}
}
