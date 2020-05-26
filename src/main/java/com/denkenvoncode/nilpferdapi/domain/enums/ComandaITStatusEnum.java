package com.denkenvoncode.nilpferdapi.domain.enums;

public enum ComandaITStatusEnum {
	
	Nenhum(0,"nenhum"),
	Ativo(1,"Ativo"),
	Cancelado(2,"Cancelado");
	
	private Integer cod;
	private String descr;
	
	private ComandaITStatusEnum(Integer cod,String descr){
		this.cod=cod;
		this.descr=descr;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}

	public static ComandaITStatusEnum toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		for (ComandaITStatusEnum c: ComandaITStatusEnum.values()) {
			if (cod.equals(c.getCod())) {
				return c;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}