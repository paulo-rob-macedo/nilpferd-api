package com.denkenvoncode.nilpferdapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Comanda;
import com.denkenvoncode.nilpferdapi.repositories.ComandaRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.DataIntegrityException;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;

@Service
public class ComandaService {

	@Autowired
	ComandaRepository repository;

	public Comanda findbyId(Long id) {
		Optional<Comanda> comanda = repository.findById(id);
		return comanda.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado - id:" + id + " , classe :" + Comanda.class.getName()));
	}
	
	@Transactional
	public Comanda insert(Comanda comanda) {
		comanda.setId(null);
		comanda = repository.save(comanda);
		return comanda;
	}	
	
	public Comanda update(Comanda comanda) {
		return repository.save(comanda);
	}	
	
	public void delete(Long id) {
		findbyId(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir pois ha produtos relacionados!");
		}
	}	
	
}
