package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.denkenvoncode.nilpferdapi.domain.enums.UsuarioPerfilEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.UsuarioStatusEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name="usuario")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Getter
	@Setter
	private Long id;
	
	@Column(name="nome",length=100)
	@NotBlank(message = "Defina o nome do usuario!")
	@Size(min=1, max=100,message="Nome deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	private String nome;
	
	@Column(name="apelido", length=50)
	@NotBlank(message = "Defina o apelido do usuario!")
	@Size(min=1, max=50,message="Apelido deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	private String apelido;
	
	@Column(name="email",unique=true, length=120)
	@NotBlank(message = "Defina o email do usuario!")
	@Size(min=1, max=200,message="Email deve ter {min} a {max} caracteres!")
	@Email(message = "Informe o email corretamente!")
	@Getter
	@Setter
	private String email;
	
	@Column(name="senha")
	@NotBlank(message = "Defina a senha do usuario!")
	@Getter
	@Setter
	private String senha;
	
	@Column(name="status")
	@Getter
	@Setter
	
	private UsuarioStatusEnum status;
	
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="usuario_perfis")
	@Column(name="perfilid")
	private Set<Integer> perfis = new HashSet<>();

	public Set<UsuarioPerfilEnum> getPerfis() {
		return perfis.stream().map(x -> UsuarioPerfilEnum.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(UsuarioPerfilEnum perfil) {
		perfis.add(perfil.getCod());
	}	
	
	public Usuario() {
		addPerfil(UsuarioPerfilEnum.Operador);
	}

	public Usuario(String nome,String apelido,String email,UsuarioStatusEnum status) {
		this.nome = nome;
		this.apelido = apelido;
		this.email = email;
		this.status = status;
		addPerfil(UsuarioPerfilEnum.Operador);
	}	

	
	
}
