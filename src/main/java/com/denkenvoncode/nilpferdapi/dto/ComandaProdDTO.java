package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import com.denkenvoncode.nilpferdapi.domain.Prod;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ComandaProdDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@EqualsAndHashCode.Include()
	private Long id;
	
	@Getter
	@Setter
	private String descr;
	
	@Getter
	@Setter
	private UnidDTO unidvenda;
	
	public ComandaProdDTO(Prod prod) {
		this.setId(prod.getId());
		this.setDescr(prod.getDescr());
		this.unidvenda.setId(prod.getUnidvenda().getId());
		this.unidvenda.setDescr(prod.getUnidvenda().getDescr());
		this.unidvenda.setQtdec(prod.getUnidvenda().getQtdec());
		this.unidvenda.setSigla(prod.getUnidvenda().getSigla());
	}
}