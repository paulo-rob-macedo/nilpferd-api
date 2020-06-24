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
import com.denkenvoncode.nilpferdapi.domain.ComandaIT;
import com.denkenvoncode.nilpferdapi.domain.ComandaITPK;
import com.denkenvoncode.nilpferdapi.domain.Prod;
import com.denkenvoncode.nilpferdapi.dto.ComandaITDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaITNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaITUpdDTO;
import com.denkenvoncode.nilpferdapi.services.ComandaITService;


@RestController
@RequestMapping(value = "/comandasit")
public class ComandaITResource {

	@Autowired
	ComandaITService service;
	
	@RequestMapping(value = "/{comandaid}/{prodid}", method = RequestMethod.GET)
	public ResponseEntity<ComandaITDTO> find(@PathVariable Long comandaid, @PathVariable Long prodid) {
		
		Comanda comanda=new Comanda();
		comanda.setId(comandaid);
		Prod prod=new Prod();
		prod.setId(prodid);
		
		ComandaITPK comandaITPK=new ComandaITPK();
		comandaITPK.setComanda(comanda);
		comandaITPK.setProd(prod);
		ComandaIT comandaIT=service.findbyId(comandaITPK);
		ComandaITDTO dto = new ComandaITDTO(comandaIT);
		return ResponseEntity.ok().body(dto);
	}	
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ComandaITNewDTO dto){
		ComandaIT comandaIT=new ComandaIT(dto);
		comandaIT=service.insert(comandaIT);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{comandaid}/{prodid}").buildAndExpand(comandaIT.getComanda().getId(),
						comandaIT.getProd().getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	
	
	@RequestMapping(value="/{comandaid}/{prodid}",method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ComandaITUpdDTO dto, @PathVariable Long comandaid, @PathVariable Long prodid){
		ComandaIT comandaIT=new ComandaIT(dto);
		ComandaITPK comandaITPK=new ComandaITPK();
		Comanda comanda=new Comanda();
		comanda.setId(comandaid);
		Prod prod=new Prod();
		prod.setId(prodid);
		comandaITPK.setComanda(comanda);
		comandaITPK.setProd(prod);
		comandaIT=service.findbyId(comandaITPK);		
		comandaIT=service.update(comandaIT);
		return ResponseEntity.noContent().build();
	}	
	
	@RequestMapping(value="/{comandaid}/{prodid}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long comandaid, @PathVariable Long prodid) {
		ComandaITPK comandaITPK=new ComandaITPK();
		Comanda comanda=new Comanda();
		comanda.setId(comandaid);
		Prod prod=new Prod();
		prod.setId(prodid);
		comandaITPK.setComanda(comanda);
		comandaITPK.setProd(prod);
		service.delete(comandaITPK);
		return ResponseEntity.noContent().build();
	}	
}
