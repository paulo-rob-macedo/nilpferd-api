package com.denkenvoncode.nilpferdapi.domain.enums;

public enum FoneStatusEnum {

	Nenhum(0,"nenhum"),
	Ativo(1,"Ativo"),
	Cancelado(2,"Cancelado");
	
	private Integer cod;
	private String descr;
	
	private FoneStatusEnum(Integer cod,String descr){
		this.cod=cod;
		this.descr=descr;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}
	
	public static FoneStatusEnum toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		for (FoneStatusEnum c: FoneStatusEnum.values()) {
			if (cod.equals(c.getCod())) {
				return c;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}	
}
