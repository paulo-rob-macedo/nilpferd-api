package com.denkenvoncode.nilpferdapi.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.denkenvoncode.nilpferdapi.domain.Prod;
import com.denkenvoncode.nilpferdapi.dto.ProdDTO;
import com.denkenvoncode.nilpferdapi.services.ProdService;


@RestController
@RequestMapping(value="/produtos")
public class ProdResource {

	@Autowired
	private ProdService service;
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProdDTO>> findAll(){
		List<Prod> list=service.findAll();
		//List<UsuarioDTO> listDTO=list.stream().map(obj -> new UsuarioDTO(obj.getId(),obj.getNome(),obj.getApelido())).collect(Collectors.toList());
		List<ProdDTO> listDTO=list.stream().map(obj -> new ProdDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Prod> find(@PathVariable Long id) {
		Prod prod = service.findbyId(id);
		return ResponseEntity.ok().body(prod);
	}	
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ProdDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Prod> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ProdDTO> listDto = list.map(obj -> new ProdDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
}
