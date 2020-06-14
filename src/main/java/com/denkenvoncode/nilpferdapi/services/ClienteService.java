package com.denkenvoncode.nilpferdapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.domain.Endereco;
import com.denkenvoncode.nilpferdapi.domain.Fone;
import com.denkenvoncode.nilpferdapi.domain.enums.ClienteStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.EnderecoStatusEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.FoneStatusEnum;
import com.denkenvoncode.nilpferdapi.dto.ClienteDTO;
import com.denkenvoncode.nilpferdapi.dto.ClienteNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ClienteUpdDTO;
import com.denkenvoncode.nilpferdapi.repositories.ClienteRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.DataIntegrityException;
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
	
	@Transactional
	public Cliente insert(Cliente cliente) {
		cliente.setId(null);
		cliente = repository.save(cliente);
		return cliente;
	}

	public Cliente update(Cliente cliente) {
		Cliente clienteUpd = repository.save(cliente);
		return clienteUpd;
	}
	
	public void delete(Long id) {
		findbyId(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir pois ha registros relacionados!");
		}
	}
		
	public Cliente fromDTO(ClienteDTO dto) {
		Cliente cliente=new Cliente(dto.getNome(),dto.getNumdoc(),dto.getEmail(),ClienteStatusEnum.Ativo);
		cliente.setId(dto.getId());
		return cliente;
	}
	
	public Cliente fromDTO(ClienteNewDTO dto) {
		Cliente cliente=new Cliente(dto.getNome(),dto.getNumdoc(),dto.getEmail(),ClienteStatusEnum.Ativo);
		cliente.setId(null);
		Endereco endereco=new Endereco(cliente,dto.getLogradouro(),dto.getNumero(),dto.getComplemento(),dto.getBairro(),dto.getCidade(),dto.getUf(),dto.getCep(),EnderecoStatusEnum.Ativo);
		Fone fone=new Fone(cliente,dto.getFone(),FoneStatusEnum.Ativo);
		cliente.getEnderecos().add(endereco);
		cliente.getFones().add(fone);
		return cliente;
	}

	public Cliente fromDTO(ClienteUpdDTO dto) {
		Cliente cliente=new Cliente(dto.getNome(),dto.getNumdoc(),dto.getEmail(),ClienteStatusEnum.Ativo);
		return cliente;
	}
}