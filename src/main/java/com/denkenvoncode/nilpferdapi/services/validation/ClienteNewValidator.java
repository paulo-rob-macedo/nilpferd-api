package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.dto.ClienteNewDTO;
import com.denkenvoncode.nilpferdapi.repositories.ClienteRepository;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;
import com.denkenvoncode.nilpferdapi.services.validation.utils.BR;

public class ClienteNewValidator implements ConstraintValidator<ClienteNew, ClienteNewDTO> {

	@Autowired
	ClienteRepository repository;
	
	@Override
	public void initialize(ClienteNew ann) {
	}

	@Override
	public boolean isValid(ClienteNewDTO dto, ConstraintValidatorContext context) {

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
		if (clie != null) {
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
