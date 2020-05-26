package com.denkenvoncode.nilpferdapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
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

import com.denkenvoncode.nilpferdapi.domain.enums.ClienteStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.ComandaStatusEnum;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comanda")
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Comanda implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@EqualsAndHashCode.Include()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@Getter
	@Setter
	private Long id;
	
	@Column(name="dtabertura")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Getter
	@Setter
	@NonNull
	private Date dtabertura;
	
	@Column(name="dtfechamento")
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	@Getter
	@Setter
	@NonNull
	private Date dtfechamento;
	
	@Column(name="status")
	@Getter
	@Setter
	@NonNull
	private ComandaStatusEnum status;
	
	@OneToOne
	@JoinColumn(name = "usuarioid", referencedColumnName = "id")
	@NotBlank(message = "Defina o codigo do usuario!")
	@Getter
	@Setter
	@NonNull
	private Usuario usuario;
	
	@OneToMany(mappedBy="id.comanda")	
	@Getter
	@Setter
	private List<ComandaIT> itens=new ArrayList<ComandaIT>();

	@OneToMany(mappedBy="comanda", cascade=CascadeType.ALL)
	@Getter
	@Setter
	private List<ComandaPagto> pagtos = new ArrayList<>();
	
}
