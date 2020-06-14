package com.denkenvoncode.nilpferdapi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.denkenvoncode.nilpferdapi.domain.Cliente;
import com.denkenvoncode.nilpferdapi.dto.ClienteDTO;
import com.denkenvoncode.nilpferdapi.dto.ClienteNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ClienteUpdDTO;
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
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ClienteNewDTO dto){
		Cliente cliente=service.fromDTO(dto);
		cliente.setId(null);
		cliente=service.insert(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteUpdDTO dto, @PathVariable Long id){
		Cliente cliente=service.fromDTO(dto);
		cliente.setId(id);
		cliente=service.update(cliente);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
