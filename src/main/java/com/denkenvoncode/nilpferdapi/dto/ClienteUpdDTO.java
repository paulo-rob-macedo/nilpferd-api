package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class ClienteUpdDTO  implements Serializable {
	
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
	private String status;	
}
