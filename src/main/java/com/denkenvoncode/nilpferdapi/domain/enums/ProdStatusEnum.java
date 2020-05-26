package com.denkenvoncode.nilpferdapi.domain.enums;

public enum ProdStatusEnum {
	Nenhum(0,"nenhum"),
	Ativo(1,"Ativo"),
	Suspenso(2,"Suspenso"),
	Cancelado(3,"Cancelado");
	
	private Integer cod;
	private String descr;
	
	private ProdStatusEnum(Integer cod,String descr){
		this.cod=cod;
		this.descr=descr;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}

	public static ProdStatusEnum toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		for (ProdStatusEnum c: ProdStatusEnum.values()) {
			if (cod.equals(c.getCod())) {
				return c;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}		
}
