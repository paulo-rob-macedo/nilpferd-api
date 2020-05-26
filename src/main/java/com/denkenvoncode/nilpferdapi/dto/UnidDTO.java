package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import com.denkenvoncode.nilpferdapi.domain.Unid;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class UnidDTO implements Serializable {
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
	private String sigla;
		
	@Getter
	@Setter
	private Integer qtdec;
		
	public UnidDTO(Unid unid) {
		this.id=unid.getId();
		this.descr=unid.getDescr();
		this.sigla=unid.getSigla();
		this.qtdec=unid.getQtdec();
	}
}
