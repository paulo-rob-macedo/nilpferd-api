package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
public class ComandaPagtoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@EqualsAndHashCode.Include()
	private Long id;
	
	@Getter
	@Setter
	private Long comandaid;
	
	@Getter
	@Setter
	private Date dtpagto;
	
	@Getter
	@Setter
	private Double pagtovl;
	
	@Getter
	@Setter
	private Integer qtdparcela;
	
	@Getter
	@Setter
	private ComandaPagtoTipoDTO tipo;
	
	@Getter
	@Setter
	private ComandaPagtoStatusDTO status;
	
}
