package com.denkenvoncode.nilpferdapi.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.domain.Prod;
import com.denkenvoncode.nilpferdapi.dto.ClienteDTO;
import com.denkenvoncode.nilpferdapi.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll(){
		List<Cliente> list=service.findAll();
		//List<UsuarioDTO> listDTO=list.stream().map(obj -> new UsuarioDTO(obj.getId(),obj.getNome(),obj.getApelido())).collect(Collectors.toList());
		List<ClienteDTO> listDTO=list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ClienteDTO> find(@PathVariable Long id) {
		Cliente clie = service.findbyId(id);
		ClienteDTO dto=new ClienteDTO(clie);	
		return ResponseEntity.ok().body(dto);
	}	
	
}
