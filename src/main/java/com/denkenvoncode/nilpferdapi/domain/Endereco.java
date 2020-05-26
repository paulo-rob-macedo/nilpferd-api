package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.denkenvoncode.nilpferdapi.domain.enums.EnderecoStatusEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="endereco")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Getter
	@Setter
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="clienteid")
	@NonNull
	private Cliente cliente;
	
	@Column(name="logradouro",length=100)
	@NotBlank(message = "Defina o logradouro")
	@Size(min=1, max=100,message="Logradouro deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String logradouro;

	@Column(name="numero",length=60)
	@NotBlank(message = "Defina o numero")
	@Size(min=1, max=60,message="Numero do Logradouro deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String numero;

	@Column(name="complemento",length=100)
	@NotBlank(message = "Defina o complemento")
	@Size(min=1, max=100,message="Complemento deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String complemento;

	@Column(name="bairro",length=100)
	@NotBlank(message = "Defina o bairro")
	@Size(min=1, max=100,message="Bairro deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String bairro;

	@Column(name="cidade",length=100)
	@NotBlank(message = "Defina a cidade")
	@Size(min=1, max=100,message="Cidade deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String cidade;

	@Column(name="uf",length=2)
	@NotBlank(message = "Defina a Unidade Federativa")
	@Size(min=1, max=2,message="UF deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String uf;

	@Column(name="cep",length=2)
	@NotBlank(message = "Defina o CEP !")
	@Size(min=1, max=8,message="CEP deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String cep;
	
	@Column(name="status")
	@Getter
	@Setter
	@NonNull
	private EnderecoStatusEnum status;
}
