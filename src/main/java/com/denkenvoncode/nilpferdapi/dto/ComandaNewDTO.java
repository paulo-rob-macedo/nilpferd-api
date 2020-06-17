package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ComandaNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	@Setter
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dtabertura;

	@Getter
	@Setter
	private Long usuarioid;

	@Getter
	@Setter
	private List<ComandaITNewDTO> itens;
}
