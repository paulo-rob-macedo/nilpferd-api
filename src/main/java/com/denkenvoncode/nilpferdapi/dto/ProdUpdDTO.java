package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import com.denkenvoncode.nilpferdapi.services.validation.ProdUpdate;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@ProdUpdate
public class ProdUpdDTO implements Serializable {
	
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
	
	@Getter
	@Setter
	private Integer statusid;
}
