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

import com.denkenvoncode.nilpferdapi.domain.Comanda;
import com.denkenvoncode.nilpferdapi.dto.ComandaDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaNewDTO;
import com.denkenvoncode.nilpferdapi.services.ComandaService;

@RestController
@RequestMapping(value="/comandas")
public class ComandaResource {

	@Autowired
	ComandaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ComandaDTO> find(@PathVariable Long id) {
		Comanda comanda= service.findbyId(id);
		ComandaDTO dto=new ComandaDTO(comanda);
		return ResponseEntity.ok().body(dto);
	}	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ComandaNewDTO dto){
		Comanda comanda=service.FromDTO(dto);
		comanda.getDescontovl();
		comanda.getTotalvl();
		comanda=service.insert(comanda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(comanda.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}
