package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.denkenvoncode.nilpferdapi.domain.Usuario;
import com.denkenvoncode.nilpferdapi.dto.UsuarioDTO;
import com.denkenvoncode.nilpferdapi.dto.UsuarioUpdDTO;
import com.denkenvoncode.nilpferdapi.repositories.UsuarioRepository;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;
import com.denkenvoncode.nilpferdapi.services.validation.utils.BR;

public class UsuarioUpdateValidator implements ConstraintValidator<UsuarioUpdate, UsuarioUpdDTO>{

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	UsuarioRepository repository;
	
	@Override
	public void initialize(UsuarioUpdate ann) {
	}
	
	@Override
	public boolean isValid(UsuarioUpdDTO dto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long uriId = Long.parseLong(map.get("id"));
		if (uriId==0) {
			list.add(new FieldMessage("id", "Não foi informado o codigo do Usuario!"));
		}
		
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
		if (usuario !=null && ! usuario.getId().equals(uriId)) {
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
