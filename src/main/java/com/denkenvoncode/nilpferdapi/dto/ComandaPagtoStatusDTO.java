package com.denkenvoncode.nilpferdapi.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
public class ComandaPagtoStatusDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Getter
	@Setter
	private Integer id;
	
	@Getter
	@Setter
	private String descr;


}
