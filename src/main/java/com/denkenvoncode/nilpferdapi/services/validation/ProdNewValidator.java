package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.denkenvoncode.nilpferdapi.dto.ProdNewDTO;
import com.denkenvoncode.nilpferdapi.repositories.UnidRepository;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;

public class ProdNewValidator implements ConstraintValidator<ProdNew, ProdNewDTO> {

	@Autowired
	UnidRepository unidRepository;
	
	@Override
	public boolean isValid(ProdNewDTO value, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (value.getDescr().trim().length()==0) {
			list.add(new FieldMessage("descr", "Descrição deve ser informada"));
		}
		if (value.getDescr().trim().length()>80) {
			list.add(new FieldMessage("descr", "Descrição deve no maximo 80 caracteres!"));
		}
		if (value.getUnidvendaid()==0) {
			list.add(new FieldMessage("unidvendaid", "Informe a Unidade de Venda!"));
		}
		if (value.getUnidcompraid()==0) {
			list.add(new FieldMessage("unidcompraid", "Informe a Unidade de Venda!"));
		}
		
		if (! unidRepository.existsById(value.getUnidvendaid())) {
			list.add(new FieldMessage("unidvendaid", "Unidade de Venda não cadastrada!"));
		}
		
		if (! unidRepository.existsById(value.getUnidcompraid())) {
			list.add(new FieldMessage("unidcompraid", "Unidade de Compra não cadastrada!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();

	}

}
