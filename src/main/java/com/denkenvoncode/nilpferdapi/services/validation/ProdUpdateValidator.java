package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.denkenvoncode.nilpferdapi.dto.ProdUpdDTO;
import com.denkenvoncode.nilpferdapi.repositories.UnidRepository;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;

public class ProdUpdateValidator implements ConstraintValidator<ProdUpdate, ProdUpdDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	UnidRepository unidRepository;
	
	@Override
	public boolean isValid(ProdUpdDTO value, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();

		if (value.getDescr().trim().length()==0) {
			list.add(new FieldMessage("descr", "Descrição deve ser informada"));
		}
		if (value.getDescr().trim().length()>80) {
			list.add(new FieldMessage("descr", "Descrição deve no maximo 80 caracteres!"));
		}
		if (value.getUnidvendaid()==0) {
			list.add(new FieldMessage("unidvenda", "Informe a Unidade de Venda!"));
		}
		if (! unidRepository.existsById(value.getUnidvendaid())) {
			list.add(new FieldMessage("unidvenda", "Unidade de Venda não cadastrada!"));
		}
		
		if (value.getPrecocompra()==0) {
			list.add(new FieldMessage("unidcompra", "Informe a Unidade de Compra!"));
		}
		if (! unidRepository.existsById(value.getUnidcompraid())) {
			list.add(new FieldMessage("unidcompra", "Unidade de Compra não cadastrada!"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
