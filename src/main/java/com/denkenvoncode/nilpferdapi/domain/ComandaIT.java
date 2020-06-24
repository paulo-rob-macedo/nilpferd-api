package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.denkenvoncode.nilpferdapi.domain.enums.ComandaITStatusEnum;
import com.denkenvoncode.nilpferdapi.dto.ComandaITDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaITNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaITUpdDTO;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Table(name="comandait")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComandaIT implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	@EqualsAndHashCode.Include()
	private ComandaITPK id=new ComandaITPK();
	
	@Column(name="seq")
	@Getter
	@Setter
	private Integer seq;
	
	@Column(name="qtd")
	@Getter
	@Setter	
	private Double qtd;
	
	@Column(name="unitariovl")
	@Getter
	@Setter
	private Double unitariovl;
	
	@Column(name="desconto")
	@Getter
	@Setter
	private Double desconto;	

	@Column(name="totalvl")
	@NonNull
	private Double totalvl;	
	
	@Column(name="status")
	@Getter
	@Setter
	private ComandaITStatusEnum status;

	public Double getTotalvl() {
		totalvl=(this.qtd*this.unitariovl);
		return totalvl;
	}

	public ComandaIT(Comanda comanda,Integer seq, Prod prod, Double qtd, Double desconto, ComandaITStatusEnum status) {
		this.id.setComanda(comanda);
		this.id.setProd(prod);
		this.seq=seq;
		this.qtd = qtd;
		this.unitariovl = prod.getPrecovenda();
		this.totalvl=getTotalvl();
		this.desconto = desconto;
		this.status = status;
	}
	
	public ComandaIT(ComandaITDTO dto) {
		ComandaITPK id=new ComandaITPK();
		id.getComanda().setId(dto.getComandaid());
		id.getProd().setId(dto.getProd().getId());
		this.seq=dto.getSeq();
		this.qtd=dto.getQtd();
		this.unitariovl=dto.getUnitariovl();
		this.desconto=dto.getDesconto();
		this.totalvl=getTotalvl();
		this.status=ComandaITStatusEnum.toEnum(dto.getStatus().getId());
	}
	
	public ComandaIT(ComandaITNewDTO dto) {
		Comanda comanda=new Comanda();
		comanda.setId(dto.getComandaid());
		Prod prod=new Prod();
		prod.setId(dto.getProdid());
		ComandaITPK id=new ComandaITPK();
		id.setProd(prod);
		id.setComanda(comanda);
		this.id=id;
		this.seq=dto.getSeq();
		this.qtd=dto.getQtd();
		this.desconto=dto.getDesconto();
		this.unitariovl=dto.getUnitariovl();
		this.totalvl=getTotalvl();
		this.status=ComandaITStatusEnum.Ativo;
	}

	public ComandaIT(ComandaITUpdDTO dto) {
		ComandaITPK id=new ComandaITPK();
		id.getComanda().setId(dto.getComandaid());
		id.getProd().setId(dto.getProdid());
		this.seq=dto.getSeq();
		this.qtd=dto.getQtd();
		this.unitariovl=dto.getUnitariovl();
		this.totalvl=getTotalvl();
	}

	public Comanda getComanda() {
		return id.getComanda();
	}
	
	public Prod getProd() {
		return id.getProd();
	}
	
}
