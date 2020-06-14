package com.denkenvoncode.nilpferdapi.services.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import com.denkenvoncode.nilpferdapi.domain.Unid;
import com.denkenvoncode.nilpferdapi.dto.UnidUpdDTO;
import com.denkenvoncode.nilpferdapi.repositories.UnidRepository;
import com.denkenvoncode.nilpferdapi.resources.exception.FieldMessage;

public class UnidUpdateValidator implements ConstraintValidator<UnidUpdate, UnidUpdDTO> {

	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	UnidRepository repository;
	
	@Override
	public boolean isValid(UnidUpdDTO value, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		@SuppressWarnings("unchecked")
		Map<String, String> map = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
		Long uriId = Long.parseLong(map.get("id"));
		if (uriId==0) {
			list.add(new FieldMessage("id", "Não foi informado o codigo da Unidade!"));
		}
	
		String descr=value.getDescr().trim();
		String sigla=value.getSigla().trim();
		if (descr.length()==0) {
			list.add(new FieldMessage("descr", "Descrição deve ser informada"));
		}
		if (descr.length()>60) {
			list.add(new FieldMessage("descr", "Descrição deve no maximo 60 caracteres!"));
		}
		if (sigla.length()==0) {
			list.add(new FieldMessage("sigla", "Descrição deve ser informada"));
		}
		if (sigla.length()>60) {
			list.add(new FieldMessage("descr", "Sigla deve no maximo 60 caracteres!"));
		}		
		Unid unid=repository.findBySigla(sigla);
		if (unid !=null && ! unid.getId().equals(uriId)) {
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
