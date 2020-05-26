package com.denkenvoncode.nilpferdapi.domain.enums;

public enum ComandaStatusEnum {

	Nenhum(0,"nenhum"),
	Ativo(1,"Ativo"),
	Cancelado(2,"Cancelado"),
	Fechado(3,"Fechado");
	
	private Integer cod;
	private String descr;
	
	private ComandaStatusEnum(Integer cod,String descr){
		this.cod=cod;
		this.descr=descr;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}
	
	public static ComandaStatusEnum toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		for (ComandaStatusEnum c: ComandaStatusEnum.values()) {
			if (cod.equals(c.getCod())) {
				return c;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}	
}
