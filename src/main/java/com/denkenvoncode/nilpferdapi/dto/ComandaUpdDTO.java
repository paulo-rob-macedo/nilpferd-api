package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;


@Data
public class ComandaUpdDTO implements Serializable {
	
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
	private Long usuarioid;

	@Getter
	@Setter
	private Integer statusid;
	
	@Getter
	@Setter
	private List<ComandaITUpdDTO> itens;	
}
