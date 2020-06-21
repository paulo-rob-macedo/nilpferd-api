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
	@NonNull
	@Getter
	@Setter
	private Comanda comanda;
	
	@Column(name="dtpagto")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Getter
	@Setter
	@NonNull
	private Date dtpagto;
	
	@Column(name="recebidovl")
	@Getter
	@Setter
	@NonNull
	private Double recebidovl;
	
	@Column(name="pagtovl")
	@Getter
	@Setter
	@NonNull
	private Double pagtovl;
	
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
		this.dtpagto=dto.getDtpagto();
		this.recebidovl=dto.getRecebidovl();
		this.pagtovl=dto.getPagtovl();
		this.qtdparcela=dto.getQtdparcela();
		this.tipo=ComandaPagtoTipoEnum.toEnum(dto.getTipo().getId());
		this.status=ComandoPagtoStatusEnum.toEnum(dto.getStatus().getId());
	}
}
