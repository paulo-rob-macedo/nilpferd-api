package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Data
public class ComandaITNewDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	

	@Getter
	@Setter
	private Long prodid;
	
	@Getter
	@Setter
	private Integer seq;
	
	@Getter
	@Setter
	private Double qtd;
	
	@Getter
	@Setter
	private Double unitariovl;
	
	@Getter
	@Setter
	private Double desconto;	

	@Getter
	@Setter
	private Double totalvl;	
	
}
