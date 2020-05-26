package com.denkenvoncode.nilpferdapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.domain.enums.ClienteStatusEnum;
import com.denkenvoncode.nilpferdapi.dto.ClienteDTO;
import com.denkenvoncode.nilpferdapi.repositories.ClienteRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll(){
		return repository.findAll();
	}
	
	public Cliente findbyId(Long id) {
		Optional<Cliente> cliente=repository.findById(id);
		return cliente.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado - id:"+id
				+" , classe :"+Cliente.class.getName()));
	}
	
	public Cliente fromDTO(ClienteDTO dto) {
		Cliente cliente=new Cliente(dto.getNome(),dto.getNumdoc(),dto.getEmail(),ClienteStatusEnum.Ativo);
		cliente.setId(dto.getId());
		return cliente;
	}
}