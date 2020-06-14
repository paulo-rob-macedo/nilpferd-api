package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ComandaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtabertura;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date dtfechamento;
	
	private String status;	
	
	private String usuario;

}
