package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.denkenvoncode.nilpferdapi.domain.Unid;
import com.denkenvoncode.nilpferdapi.dto.UnidNewDTO;
import com.denkenvoncode.nilpferdapi.repositories.UnidRepository;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;

public class UnidNewValidator implements ConstraintValidator<UnidNew, UnidNewDTO> {

	@Autowired
	UnidRepository repository;

	@Override
	public boolean isValid(UnidNewDTO value, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		String descr = value.getDescr().trim();
		String sigla = value.getSigla().trim();
		if (descr.length() == 0) {
			list.add(new FieldMessage("descr", "Descrição deve ser informada"));
		}
		if (descr.length() > 60) {
			list.add(new FieldMessage("descr", "Descrição deve no maximo 60 caracteres!"));
		}
		if (sigla.length() == 0) {
			list.add(new FieldMessage("sigla", "Descrição deve ser informada"));
		}
		if (sigla.length() > 60) {
			list.add(new FieldMessage("descr", "Sigla deve no maximo 60 caracteres!"));
		}

		Unid unid = repository.findBySigla(sigla);
		if (unid != null) {
			list.add(new FieldMessage("sigla", "A sigla informada ja foi cadastrada em outra Unidade!"));
		}
		
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
