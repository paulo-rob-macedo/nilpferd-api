package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.denkenvoncode.nilpferdapi.domain.enums.ClienteStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.FoneStatusEnum;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cliente")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Cliente implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Getter
	@Setter
	private Long id;

	@Column(name="nome",length=100)
	@NotBlank(message = "Defina o nome do cliente!")
	@Size(min=1, max=100,message="Nome deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String nome;
	
	@Column(name="email",unique=true, length=120)
	@NotBlank(message = "Defina o email do cliente!")
	@Size(min=1, max=200,message="Email deve ter {min} a {max} caracteres!")
	@Email(message = "Informe o email corretamente!")
	@Getter
	@Setter
	@NonNull
	private String email;
	
	@Column(name="numdoc",length=14)
	@NotBlank(message = "Defina o numero do documento")
	@Size(min=1, max=14,message="numero do documento deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String numdoc;
	
	@Column(name="status")
	@Getter
	@Setter
	@NonNull
	private ClienteStatusEnum status;
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	@Getter
	@Setter
	private List<Endereco> enderecos = new ArrayList<>();
	
	@OneToMany(mappedBy="cliente", cascade=CascadeType.ALL)
	@Getter
	@Setter
	private List<Fone> fones = new ArrayList<>();
	
}
