package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ComandaPagtoNewDTO implements Serializable {

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
	private Date dtvenc;

	@Getter
	@Setter
	private Double vencvl;

	@Getter
	@Setter
	private Date dtpagto;

	@Getter
	@Setter
	private Double pagtovl;
	
	@Getter
	@Setter
	private Double recebidovl;
		
	@Getter
	@Setter
	private Double trocovl;
	
	@Getter
	@Setter
	private Integer qtdparcela;

	@Getter
	@Setter
	private ComandaPagtoTipoDTO tipo=new ComandaPagtoTipoDTO();

	@Getter
	@Setter
	private ComandaPagtoStatusDTO status=new ComandaPagtoStatusDTO();
	

}
