package com.denkenvoncode.nilpferdapi.domain.enums;

public enum ComandoPagtoStatusEnum {

	Nenhum(0,"nenhum"),
	Ativo(1,"Ativo"),
	Cancelado(2,"Cancelado");
	
	private Integer cod;
	private String descr;
	
	private ComandoPagtoStatusEnum(Integer cod,String descr){
		this.cod=cod;
		this.descr=descr;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}
	
	public static ComandoPagtoStatusEnum toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		for (ComandoPagtoStatusEnum c: ComandoPagtoStatusEnum.values()) {
			if (cod.equals(c.getCod())) {
				return c;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}	
}
