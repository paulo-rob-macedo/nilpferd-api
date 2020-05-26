package com.denkenvoncode.nilpferdapi.domain.enums;

public enum ClienteStatusEnum {

	Nenhum(0,"nenhum"),
	Ativo(1,"Ativo"),
	Suspenso(2,"Suspenso"),
	Cancelado(3,"Cancelado");
	
	private Integer cod;
	private String descr;
	
	private ClienteStatusEnum(Integer cod,String descr){
		this.cod=cod;
		this.descr=descr;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}
	
	public static ClienteStatusEnum toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		for (ClienteStatusEnum c: ClienteStatusEnum.values()) {
			if (cod.equals(c.getCod())) {
				return c;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
