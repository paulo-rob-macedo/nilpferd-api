package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.denkenvoncode.nilpferdapi.domain.enums.ComandaITStatusEnum;

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
	@Getter
	@Setter
	private Double totalvl;	
	
	@Column(name="status")
	@Getter
	@Setter
	private ComandaITStatusEnum status;

//	public Double getTotalvl() {
//		totalvl=this.qtd*this.unitariovl;
//		return totalvl;
//	}

	public ComandaIT(Comanda comanda, Prod prod, Double qtd, Double unitariovl, Double desconto, Double totalvl,
			ComandaITStatusEnum status) {
		this.id.setComanda(comanda);
		this.id.setProd(prod);
		this.qtd = qtd;
		this.unitariovl = unitariovl;
		this.desconto = desconto;
		this.totalvl = totalvl;
		this.status = status;
	}
	
	public Comanda getComanda() {
		return id.getComanda();
	}
	
	public Prod getProd() {
		return id.getProd();
	}
	
}
