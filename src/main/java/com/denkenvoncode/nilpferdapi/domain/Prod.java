package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.denkenvoncode.nilpferdapi.domain.enums.ProdStatusEnum;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="prod")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Prod implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Getter
	@Setter
	private Long id;
	
	@Column(name="descr",length=100)
	@NotBlank(message = "Defina a descrição do produto!")
	@Size(min=1, max=80,message="Descrição deve ter {min} a {max} caracteres!")
	@Getter
	@Setter
	@NonNull
	private String descr;

	@Column(name="precovenda")
	@Getter
	@Setter
	@NonNull
	private Double precovenda;
	
	@Column(name="precocompra")
	@Getter
	@Setter
	@NonNull
	private Double precocompra;

	@OneToOne
	@JoinColumn(name = "unidvendaid", referencedColumnName = "id")
	@Getter
	@Setter
	@NonNull
	private Unid unidvenda;
	
	@OneToOne
	@JoinColumn(name = "unidcompraid", referencedColumnName = "id")
	@Getter
	@Setter
	@NonNull
	private Unid unidcompra;
	
	@Column(name="status")
	@Getter
	@Setter
	@NonNull
	private ProdStatusEnum status;
	
	@OneToMany(mappedBy="id.prod")	
	@Getter
	@Setter
	private List<ComandaIT> comandaitens=new ArrayList<ComandaIT>();
}
