package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;

import com.denkenvoncode.nilpferdapi.domain.ComandaPagto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Data
@NoArgsConstructor
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
	private Double recebidovl;
		
	@Getter
	@Setter
	private Double pagtovl;

	@Getter
	@Setter
	private Integer qtdparcela;

	@Getter
	@Setter
	private ComandaPagtoTipoDTO tipo=new ComandaPagtoTipoDTO();

	@Getter
	@Setter
	private ComandaPagtoStatusDTO status=new ComandaPagtoStatusDTO();

	public ComandaPagtoDTO(ComandaPagto pagto) {
		this.id=pagto.getId();
		this.comandaid = pagto.getComanda().getId();
		this.dtpagto=pagto.getDtpagto();
		this.pagtovl=pagto.getPagtovl();
		this.qtdparcela=pagto.getQtdparcela();
		this.tipo.setId(pagto.getTipo().getCod());
		this.tipo.setDescr(pagto.getTipo().getDescr());
		this.status.setId(pagto.getStatus().getCod());
		this.status.setDescr(pagto.getStatus().getDescr());
	}
}
