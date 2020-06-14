package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.denkenvoncode.nilpferdapi.domain.Usuario;
import com.denkenvoncode.nilpferdapi.dto.UsuarioNewDTO;
import com.denkenvoncode.nilpferdapi.repositories.UsuarioRepository;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;
import com.denkenvoncode.nilpferdapi.services.validation.utils.BR;

public class UsuarioNewValidator implements ConstraintValidator<UsuarioNew, UsuarioNewDTO>{

	@Autowired
	UsuarioRepository repository;
	
	@Override
	public void initialize(UsuarioNew ann) {
	}

	@Override
	public boolean isValid(UsuarioNewDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		if (dto.getNome().trim().length()==0) {
			list.add(new FieldMessage("nome", "Nome deve ser informado!"));
		}
		if (dto.getNome().trim().length()>100) {
			list.add(new FieldMessage("nome", "Nome deve conter ate 50 caracteres!"));
		}
		if (dto.getApelido().trim().length()==0) {
			list.add(new FieldMessage("apelido", "Apelido deve ser informado!"));
		}
		if (dto.getApelido().trim().length()>50) {
			list.add(new FieldMessage("apelido", "Apelido deve conter ate 50 caracteres!"));
		}
		if (dto.getEmail().trim().length()==0) {
			list.add(new FieldMessage("email", "Email deve ser informado!"));
		}
		if (dto.getEmail().trim().length()>120) {
			list.add(new FieldMessage("email", "Email deve conter ate 120 caracteres!"));
		}
		if (! BR.isValidEmailAddressRegex(dto.getEmail().trim())) {
			list.add(new FieldMessage("email", "Email informado não é valido!"));
		}
		
		Usuario usuario=repository.findByEmail(dto.getEmail().trim());
		if (usuario !=null) {
			list.add(new FieldMessage("email", "Email ja cadastrado para outro usuario!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}
}
