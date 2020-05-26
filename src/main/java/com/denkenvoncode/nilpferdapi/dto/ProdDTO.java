package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import com.denkenvoncode.nilpferdapi.domain.Prod;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ProdDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include()
	@Getter
	@Setter
	private Long id;
	
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
	private String unidvendasigla;
	
	@Getter
	@Setter
	private String unidcomprasigla;
	
	public ProdDTO(Prod prod) {
		this.id=prod.getId();
		this.descr=prod.getDescr();
		this.precovenda=prod.getPrecovenda();
		this.precocompra=prod.getPrecocompra();
		this.unidvendasigla=prod.getUnidvenda().getSigla();
		this.unidcomprasigla=prod.getUnidcompra().getSigla();
	}
}
