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

	@Column(name="trocovl")
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

	public ComandaPagtoDTO(ComandaPagto pagto) {
		this.id=pagto.getId();
		this.comandaid = pagto.getComanda().getId();
		this.dtvenc=pagto.getDtpagto();
		this.vencvl=pagto.getVencvl();
		this.dtpagto=pagto.getDtpagto();
		this.pagtovl=pagto.getPagtovl();
		this.recebidovl=pagto.getRecebidovl();
		this.trocovl=pagto.getTrocovl();
		this.qtdparcela=pagto.getQtdparcela();
		this.tipo.setId(pagto.getTipo().getCod());
		this.tipo.setDescr(pagto.getTipo().getDescr());
		this.status.setId(pagto.getStatus().getCod());
		this.status.setDescr(pagto.getStatus().getDescr());
	}
	
	public ComandaPagtoDTO(ComandaPagtoNewDTO dto) {
		this.comandaid=dto.getComandaid();
		this.dtvenc=dto.getDtvenc();
		this.vencvl=dto.getVencvl();
		this.dtpagto=dto.getDtpagto();
		this.pagtovl=dto.getPagtovl();
		this.recebidovl=dto.getRecebidovl();
		this.trocovl=dto.getTrocovl();
		this.qtdparcela=dto.getQtdparcela();
		this.tipo.setId(dto.getTipo().getId());
		this.tipo.setDescr(dto.getTipo().getDescr());
		this.status.setId(dto.getStatus().getId());
		this.status.setDescr(dto.getStatus().getDescr());
	}
	
	public ComandaPagtoDTO(ComandaPagtoUpdDTO dto) {
		this.id=dto.getId();
		this.comandaid=dto.getComandaid();
		this.dtvenc=dto.getDtvenc();
		this.vencvl=dto.getVencvl();
		this.dtpagto=dto.getDtpagto();
		this.pagtovl=dto.getPagtovl();
		this.recebidovl=dto.getRecebidovl();
		this.trocovl=dto.getTrocovl();
		this.qtdparcela=dto.getQtdparcela();
		this.tipo.setId(dto.getTipo().getId());
		this.status.setId(dto.getStatus().getId());
		
	}
}
