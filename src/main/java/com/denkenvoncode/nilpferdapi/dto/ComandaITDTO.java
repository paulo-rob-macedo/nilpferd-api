package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ComandaITDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long comandaid;
	
	private Long prodid;
	
	private Integer seq;
	
	private Double qtd;
	
	private Double unitariovl;
	
	private Double desconto;	

	private Double totalvl;	
	
	private String status;	
	
}
