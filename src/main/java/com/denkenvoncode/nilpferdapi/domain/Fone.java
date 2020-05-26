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

import com.denkenvoncode.nilpferdapi.domain.enums.FoneStatusEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="fone")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Fone  implements Serializable{

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
	
	@Column(name="numero",length=20)
	@NotBlank(message = "Defina o numero do telefone!")
	@Size(min=1, max=20,message="Nome deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String numero;
	
	@Column(name="status")
	@Getter
	@Setter
	@NonNull
	private FoneStatusEnum status;

}
