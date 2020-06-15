package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.denkenvoncode.nilpferdapi.domain.Comanda;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ComandaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	@EqualsAndHashCode.Include()
	private Long id;
	
	@Getter
	@Setter
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtabertura;
	
	@Getter
	@Setter
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtfechamento;
	
	@Getter
	@Setter
	private ComandaUsuarioDTO usuario;
	
	@Getter
	@Setter
	private ComandaStatusDTO status;
	
	@Getter
	@Setter
	private List<ComandaITDTO> itens;
	
	@Getter
	@Setter
	private List<ComandaPagtoDTO> pags;
	
	public ComandaDTO(Comanda comanda) {
		
		this.id=comanda.getId();
		this.dtabertura=comanda.getDtabertura();
		this.dtfechamento=comanda.getDtfechamento();
		this.usuario.setId(comanda.getUsuario().getId());
		this.usuario.setNome(comanda.getUsuario().getNome());
		this.status.setId(comanda.getStatus().getCod());
		this.status.setDescr(comanda.getStatus().getDescr());
		
	}
	
}
