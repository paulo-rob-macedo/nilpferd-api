package com.denkenvoncode.nilpferdapi.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.denkenvoncode.nilpferdapi.domain.Comanda;
import com.denkenvoncode.nilpferdapi.services.ComandaService;

@RestController
@RequestMapping(value="/comandas")
public class ComandaResource {

	@Autowired
	ComandaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Comanda> find(@PathVariable Long id) {
		Comanda comanda=service.findbyId(id);
		return ResponseEntity.ok().body(comanda);
	}		

}
