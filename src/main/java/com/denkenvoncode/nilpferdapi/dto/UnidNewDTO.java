package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class UnidNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotBlank(message = "Defina a descrição da Unidade")
	@Getter
	@Setter
	private String descr;
	
	@NotBlank(message = "Defina a sigla da Unidade")
	@Getter
	@Setter
	private String sigla;
		
	@Getter
	@Setter
	private Integer qtdec;
}
