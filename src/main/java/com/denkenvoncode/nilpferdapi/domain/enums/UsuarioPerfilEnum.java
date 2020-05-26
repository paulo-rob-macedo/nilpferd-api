package com.denkenvoncode.nilpferdapi.domain.enums;

public enum UsuarioPerfilEnum {
	
	Operador(1,"ROLE_OPERADOR"),
	Fiscal(2,"ROLE_FISCAL"),
	Gerente(3,"ROLE_GERENTE"),
	Proprietario(4,"ROLE_PROPRIETARIO"),
	Admin(5,"ROLE_ADMINISTRADOR");
	
	private Integer cod;
	private String descr;
	
	private UsuarioPerfilEnum(Integer cod,String descr){
		this.cod=cod;
		this.descr=descr;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescr() {
		return descr;
	}

	public static UsuarioPerfilEnum toEnum(Integer cod) {
		if (cod==null) {
			return null;
		}
		for (UsuarioPerfilEnum c: UsuarioPerfilEnum.values()) {
			if (cod.equals(c.getCod())) {
				return c;
			}
		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
