package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.denkenvoncode.nilpferdapi.services.validation.UnidNew;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@UnidNew
public class UnidNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private String descr;
	
	@Getter
	@Setter
	private String sigla;
		
	@Getter
	@Setter
	private Integer qtdec;
}
