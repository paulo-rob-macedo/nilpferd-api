package com.denkenvoncode.nilpferdapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.domain.ComandaIT;
import com.denkenvoncode.nilpferdapi.domain.ComandaITPK;
import com.denkenvoncode.nilpferdapi.repositories.ComandaITRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.DataIntegrityException;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;

@Service
public class ComandaITService {

	@Autowired
	ComandaITRepository repository;
	
	public ComandaIT findbyId(ComandaITPK comandaITPK) {
		Optional<ComandaIT> comandaIT=repository.findById(comandaITPK);
		return comandaIT.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado - "
				+"Comanda: "+comandaITPK.getComanda().getId()+" - "
				+"Produto: "+comandaITPK.getProd().getId()+" - "
				+" , classe :"+ComandaIT.class.getName()));
	}
	
	@Transactional
	public ComandaIT insert(ComandaIT comandaIT) {
		comandaIT = repository.save(comandaIT);
		return comandaIT;
	}	
	
	public ComandaIT update(ComandaIT comandaIT) {
		return repository.save(comandaIT);
	}	
	
	public void delete(ComandaITPK comandaITPK) {
		findbyId(comandaITPK);
		try {
			repository.deleteById(comandaITPK);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir ite, pois ha comanda relacionados!");
		}
	}	
	
}
