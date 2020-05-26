package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.denkenvoncode.nilpferdapi.dto.UsuarioNewDTO;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;

public class UsuarioNewValidator implements ConstraintValidator<UsuarioNew, UsuarioNewDTO>{

	@Override
	public void initialize(UsuarioNew ann) {
	}

	@Override
	public boolean isValid(UsuarioNewDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
