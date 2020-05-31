package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ProdNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
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
