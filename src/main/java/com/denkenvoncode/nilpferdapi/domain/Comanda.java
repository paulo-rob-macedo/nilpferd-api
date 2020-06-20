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

import com.denkenvoncode.nilpferdapi.domain.enums.ComandaStatusEnum;
import com.denkenvoncode.nilpferdapi.dto.ComandaNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaUpdDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

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
	private Date dtfechamento;
	
	@Column(name="descontovl")
	@NonNull
	private Double descontovl;	

	@Column(name="totalvl")
	@NonNull
	private Double totalvl;	
	
	@Column(name="status")
	@Getter
	@Setter
	@NonNull
	private ComandaStatusEnum status;
	
	@OneToOne
	@JoinColumn(name = "usuarioid", referencedColumnName = "id")
//	@NotBlank(message = "Defina o codigo do usuario!")
	@Getter
	@Setter
	@NonNull
	private Usuario usuario;
	
	@OneToMany(mappedBy="id.comanda",cascade=CascadeType.ALL)	
	@Getter
	@Setter
	private List<ComandaIT> itens=new ArrayList<ComandaIT>();

	@OneToMany(mappedBy="comanda", cascade=CascadeType.ALL)
	@Getter
	@Setter
	private List<ComandaPagto> pagtos = new ArrayList<>();
	
	
	public Double getDescontovl() {
		this.descontovl=getItens().stream()
				.mapToDouble(x -> x.getDesconto())
				.sum();
		return this.descontovl;
	}
	
	public Double getTotalvl() {
		this.totalvl=getItens().stream()
				.mapToDouble(x->x.getTotalvl())
				.sum();
		return this.totalvl;
	}
	
	public Comanda(ComandaNewDTO dto) {
//		Usuario usuario=new Usuario();
//		usuario.setId(id);
//		usuario.setId(dto.getUsuarioid());
		this.dtabertura=dto.getDtabertura();
		this.status=ComandaStatusEnum.Ativo;
//		this.usuario=usuario;
	}
	
	public Comanda(ComandaUpdDTO dto) {
		this.dtabertura=dto.getDtabertura();
		this.status=ComandaStatusEnum.toEnum(dto.getStatusid());
		//this.usuario.setId(dto.getUsuarioid());
	}


}
