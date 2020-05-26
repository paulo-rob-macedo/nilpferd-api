package com.denkenvoncode.nilpferdapi.resources.exception;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
public class StandardError  implements Serializable{

	private static final long serialVersionUID = 1L;
	@Getter
	@Setter
	private Integer status;
	
	@Getter
	@Setter
	private String error;
	
	@Getter
	@Setter
	private String msg;
	
	@Getter
	@Setter
	private Long timestamp;
	
	@Getter
	@Setter
	private String  path;
	
	
}
