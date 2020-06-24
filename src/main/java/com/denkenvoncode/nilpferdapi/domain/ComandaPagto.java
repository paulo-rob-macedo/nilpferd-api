package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.denkenvoncode.nilpferdapi.domain.enums.ComandaPagtoTipoEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.ComandoPagtoStatusEnum;
import com.denkenvoncode.nilpferdapi.dto.ComandaPagtoDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaPagtoNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaPagtoUpdDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comandapagto")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComandaPagto implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Getter
	@Setter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="comandaid")
	@Getter
	@Setter
	@NonNull
	private Comanda comanda;
	
	@Column(name="dtvenc")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Getter
	@Setter
	@NonNull
	private Date dtvenc;
	
	@Column(name="vencvl")
	@Getter
	@Setter
	@NonNull
	private Double vencvl;	
	
	@Column(name="dtpagto")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Getter
	@Setter
	private Date dtpagto;
	
	@Column(name="pagtovl")
	@Getter
	@Setter
	private Double pagtovl;
	
	@Column(name="recebidovl")
	@Getter
	@Setter
	private Double recebidovl;

	@Column(name="trocovl")
	@Getter
	@Setter
	private Double trocovl;
	
	@Column(name="qtdparcela")
	@Getter
	@Setter
	@NonNull
	private Integer qtdparcela;
	
	@Column(name="tipo")
	@Getter
	@Setter
	@NonNull
	private ComandaPagtoTipoEnum tipo;
	
	@Column(name="status")
	@Getter
	@Setter
	@NonNull
	private ComandoPagtoStatusEnum status;
	
	public ComandaPagto(ComandaPagtoDTO dto) {
		this.id=dto.getId();
		this.comanda.setId(dto.getComandaid());
		this.dtvenc=dto.getDtvenc();
		this.vencvl=dto.getVencvl();
		this.dtpagto=dto.getDtpagto();
		this.pagtovl=dto.getPagtovl();
		this.qtdparcela=dto.getQtdparcela();
		this.tipo=ComandaPagtoTipoEnum.toEnum(dto.getTipo().getId());
		this.status=ComandoPagtoStatusEnum.toEnum(dto.getStatus().getId());
	}
	
	public ComandaPagto(ComandaPagtoNewDTO dto) {
		this.comanda.setId(dto.getComandaid());
		this.dtvenc=dto.getDtvenc();
		this.vencvl=dto.getVencvl();
		this.qtdparcela=dto.getQtdparcela();
		this.tipo=ComandaPagtoTipoEnum.Dinheiro;
		this.status=ComandoPagtoStatusEnum.Ativo;
	}	
	
	public ComandaPagto(ComandaPagtoUpdDTO dto) {
		this.id=dto.getId();
		this.comanda.setId(dto.getComandaid());
		this.dtpagto=dto.getDtpagto();
		this.pagtovl=dto.getPagtovl();
		this.recebidovl=dto.getRecebidovl();
		this.pagtovl=dto.getPagtovl();
		this.qtdparcela=dto.getQtdparcela();
		this.tipo=ComandaPagtoTipoEnum.toEnum(dto.getTipo().getId());
		this.status=ComandoPagtoStatusEnum.toEnum(dto.getStatus().getId());		
	}
}
