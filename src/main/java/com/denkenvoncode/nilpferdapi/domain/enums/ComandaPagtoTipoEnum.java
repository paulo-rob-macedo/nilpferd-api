package com.denkenvoncode.nilpferdapi.domain.enums;

public enum ComandaPagtoTipoEnum {

	Nenhum(0,"nenhum"),
	Dinheiro(1,"Dinheiro"),
	Debito(2,"Debito"),
	Credito(3,"Credito"),
	Boleto(4,"Boleto");
	
	private Integer cod;
	private String descr;
	
	private ComandaPagtoTipoEnum(Integer cod,String descr){
		this.cod=cod;
		this.descr=descr;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}
	
	public static ComandaPagtoTipoEnum toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		for (ComandaPagtoTipoEnum c: ComandaPagtoTipoEnum.values()) {
			if (cod.equals(c.getCod())) {
				return c;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
