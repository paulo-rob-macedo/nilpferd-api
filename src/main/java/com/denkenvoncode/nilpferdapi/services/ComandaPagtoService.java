package com.denkenvoncode.nilpferdapi.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Comanda;
import com.denkenvoncode.nilpferdapi.domain.ComandaPagto;
import com.denkenvoncode.nilpferdapi.repositories.ComandaPagtoRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.DataIntegrityException;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;

@Service
public class ComandaPagtoService {

	@Autowired
	ComandaPagtoRepository repository;
	
	public ComandaPagto findbyId(Long id) {
		Optional<ComandaPagto> pagto = repository.findById(id);
		return pagto.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado - id:" + id + " , classe :" + ComandaPagto.class.getName()));
	}	
	
	@Transactional
	public ComandaPagto insert(ComandaPagto pagto) {
		pagto.setId(null);
		pagto = repository.save(pagto);
		return pagto;
	}	
	
	public ComandaPagto update(ComandaPagto pagto) {
		return repository.save(pagto);
	}	
	
	public void delete(Long id) {
		findbyId(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir pagamento pois ha comanda relacionados!");
		}
	}	
}
