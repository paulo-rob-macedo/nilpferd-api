package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.dto.ClienteDTO;
import com.denkenvoncode.nilpferdapi.repositories.ClienteRepository;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;
import com.denkenvoncode.nilpferdapi.services.validation.utils.BR;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	ClienteRepository repository;
	
	@Override
	public void initialize(ClienteUpdate ann) {
	}

	@Override
	public boolean isValid(ClienteDTO dto, ConstraintValidatorContext context) {

		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Integer uriId = Integer.parseInt(map.get("id"));
		
		List<FieldMessage> list = new ArrayList<>();
		
		String numDoc=dto.getNumdoc().trim();
		
		if ((numDoc.length()<=11) 
			&& !BR.isValidCPF(numDoc)) {
			list.add(new FieldMessage("numdoc", "CPF inválido"));
		}
		if ((numDoc.length()>11) 
			&& !BR.isValidCNPJ(numDoc)) {
					list.add(new FieldMessage("numdoc", "CNPJ inválido"));
				}

		Cliente clie=repository.findByEmail(dto.getEmail());
		if (clie != null && !clie.getId().equals(uriId)) {
			list.add(new FieldMessage("email", "Email ja cadastrado!"));
		}
//		Cliente aux = repo.findByEmail(objDto.getEmail());
//		if (aux != null) {
//			list.add(new FieldMessage("email", "Email já existente"));
//		}

		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
