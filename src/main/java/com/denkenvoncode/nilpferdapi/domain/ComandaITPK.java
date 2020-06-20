package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComandaITPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "comandaid",referencedColumnName = "id")
	@Getter
	@Setter
	@EqualsAndHashCode.Include()
	private Comanda comanda;
	
	@ManyToOne
	@JoinColumn(name = "prodid",referencedColumnName = "id")
	@Getter
	@Setter
	@EqualsAndHashCode.Include()
	private Prod prod;
	
}
