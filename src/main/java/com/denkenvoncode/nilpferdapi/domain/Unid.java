package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="unid")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Unid implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include()
	@Column(name="id")
	@Getter
	@Setter
	private Long id;
	
	@Column(name="descr",length=60)
	@NotBlank(message = "Defina a descrição da Unidade")
	@Size(min=1, max=60,message="Descrição deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String descr;

	@Column(name="sigla",length=60)
	@NotBlank(message = "Defina a sigla da Unidade")
	@Size(min=1, max=60,message="Sigla deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String sigla;
	
	@Column(name="qtdec")
	@Getter
	@Setter
	@NonNull
	private Integer qtdec;
}
