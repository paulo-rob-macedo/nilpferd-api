package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import com.denkenvoncode.nilpferdapi.services.validation.UnidUpdate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@UnidUpdate
public class UnidUpdDTO implements Serializable {
	
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
