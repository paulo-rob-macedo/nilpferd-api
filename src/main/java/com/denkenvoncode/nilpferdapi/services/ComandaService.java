package com.denkenvoncode.nilpferdapi.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Comanda;
import com.denkenvoncode.nilpferdapi.domain.ComandaIT;
import com.denkenvoncode.nilpferdapi.domain.ComandaPagto;
import com.denkenvoncode.nilpferdapi.domain.Usuario;
import com.denkenvoncode.nilpferdapi.dto.ComandaNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaUpdDTO;
import com.denkenvoncode.nilpferdapi.repositories.ComandaRepository;
import com.denkenvoncode.nilpferdapi.repositories.UsuarioRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.DataIntegrityException;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;

@Service
public class ComandaService {

	@Autowired
	ComandaRepository repository;

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Comanda> findAll(){
		return repository.findAll();
	}
		
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
	
	public Comanda FromDTO(ComandaNewDTO dto) {
		Optional<Usuario> usuario=usuarioRepository.findById(dto.getUsuarioid());
		Comanda comanda=new Comanda(dto);
		comanda.setUsuario(usuario.get());
		comanda.getItens().addAll(dto.getItens().stream().map(obj -> new ComandaIT(obj)).collect(Collectors.toList()));
		return comanda;
	}
	
	public Comanda FromDTO(ComandaUpdDTO dto) {
		//Usuario usuario=usuarioRepository.getOne(dto.getUsuarioid());
		Comanda comanda=new Comanda(dto);
		comanda.getItens().addAll(dto.getItens().stream().map(obj -> new ComandaIT(obj)).collect(Collectors.toList()));
		comanda.getPagtos().addAll(dto.getPags().stream().map(obj-> new ComandaPagto(obj)).collect(Collectors.toList()));
		return comanda;
	}
}
