package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProdNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@NotBlank(message = "Defina a descrição do produto!")
	private String descr;
	
	@Getter
	@Setter
	private Double precovenda;

	@Getter
	@Setter
	private Double precocompra;
	
	@Getter
	@Setter	
	private Long unidvendaid;
	
	@Getter
	@Setter
	private Long unidcompraid;
	
}
