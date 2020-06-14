package com.denkenvoncode.nilpferdapi.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.denkenvoncode.nilpferdapi.domain.Unid;
import com.denkenvoncode.nilpferdapi.dto.UnidDTO;
import com.denkenvoncode.nilpferdapi.dto.UnidNewDTO;
import com.denkenvoncode.nilpferdapi.dto.UnidUpdDTO;
import com.denkenvoncode.nilpferdapi.services.UnidService;


@RestController
@RequestMapping(value="/unidades")
public class UnidResource {

	@Autowired
	private UnidService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<UnidDTO>> findAll(){
		List<Unid> list=service.findAll();
		//List<UsuarioDTO> listDTO=list.stream().map(obj -> new UsuarioDTO(obj.getId(),obj.getNome(),obj.getApelido())).collect(Collectors.toList());
		List<UnidDTO> listDTO=list.stream().map(obj -> new UnidDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Unid> find(@PathVariable Long id) {
		Unid unid = service.findbyId(id);
		return ResponseEntity.ok().body(unid);
	}	
	
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UnidNewDTO dto){
		Unid unid=service.fromDTO(dto);
		unid=service.insert(unid);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(unid.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UnidUpdDTO dto, @PathVariable Long id){
		Unid unid=service.fromDTO(dto);
		unid.setId(id);
		unid=service.update(unid);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMINISTRADOR')")
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}	
}
