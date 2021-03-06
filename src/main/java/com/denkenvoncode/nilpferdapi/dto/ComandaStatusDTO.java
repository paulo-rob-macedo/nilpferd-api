package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class ComandaStatusDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String descr;
	

}
