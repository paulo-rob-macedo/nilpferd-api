package com.denkenvoncode.nilpferdapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.denkenvoncode.nilpferdapi.domain.Prod;
import com.denkenvoncode.nilpferdapi.repositories.ProdRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;


@Service
public class ProdService {

	@Autowired
	private ProdRepository repository;
	
	public List<Prod> findAll(){
		return repository.findAll();
	}
	
	public List<Prod> findAllByOrderDescr(){
		return repository.findAllByOrderByDescr();
	}
	
	public Prod findbyId(Long id) {
		Optional<Prod> prod=repository.findById(id);
		return prod.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado - id:"+id
				+" , classe :"+Prod.class.getName()));
		//return prod.get();
		//return usuario.orElseThrow(() -> new ObjectNotFoundException(
		//	
	}
	
	public Page<Prod> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
}
