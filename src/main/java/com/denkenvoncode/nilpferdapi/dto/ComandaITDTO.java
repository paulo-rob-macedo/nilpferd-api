package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import com.denkenvoncode.nilpferdapi.domain.ComandaIT;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ComandaITDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	private Long comandaid;

	@Getter
	@Setter
	private ComandaProdDTO prod = new ComandaProdDTO();

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

	@Getter
	@Setter
	private ComandaITStatusDTO status=new ComandaITStatusDTO();

	public ComandaITDTO(ComandaIT comandaIT) {

		UnidDTO unidVenda = new UnidDTO(comandaIT.getProd().getUnidvenda());

		this.comandaid = comandaIT.getComanda().getId();
		this.prod.setId(comandaIT.getProd().getId());
		this.prod.setDescr(comandaIT.getProd().getDescr());
		this.prod.setUnidvenda(unidVenda);
		this.seq = comandaIT.getSeq();
		this.qtd = comandaIT.getQtd();
		this.unitariovl = comandaIT.getUnitariovl();
		this.desconto = comandaIT.getDesconto();
		this.totalvl = comandaIT.getTotalvl();
		this.status.setId(comandaIT.getStatus().getCod());
		this.status.setDescr(comandaIT.getStatus().getDescr());

	}

}
