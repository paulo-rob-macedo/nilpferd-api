package com.denkenvoncode.nilpferdapi.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.denkenvoncode.nilpferdapi.domain.ComandaPagto;
import com.denkenvoncode.nilpferdapi.dto.ComandaPagtoDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaPagtoNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaPagtoUpdDTO;
import com.denkenvoncode.nilpferdapi.services.ComandaPagtoService;

@RestController
@RequestMapping(value = "/comandaspagto")
public class ComandaPgtoResource {

	@Autowired
	ComandaPagtoService service;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ComandaPagtoDTO> find(@PathVariable Long id) {
		ComandaPagto pagto = service.findbyId(id);
		ComandaPagtoDTO dto = new ComandaPagtoDTO(pagto);
		return ResponseEntity.ok().body(dto);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ComandaPagtoNewDTO dto){
		ComandaPagto pagto=new ComandaPagto(dto);
		pagto=service.insert(pagto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pagto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
	
	@RequestMapping(value="/{id}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ComandaPagtoUpdDTO dto, @PathVariable Long id){
		ComandaPagto pagto=new ComandaPagto(dto);
		pagto.setId(id);
		pagto=service.update(pagto);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
