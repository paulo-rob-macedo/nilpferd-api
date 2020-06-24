package com.denkenvoncode.nilpferdapi.resources;

import java.net.URI;
import java.util.Arrays;
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

import com.denkenvoncode.nilpferdapi.domain.Comanda;
import com.denkenvoncode.nilpferdapi.dto.ComandaDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ComandaUpdDTO;
import com.denkenvoncode.nilpferdapi.services.ComandaService;

@RestController
@RequestMapping(value = "/comandas")
public class ComandaResource {

	@Autowired
	ComandaService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<ComandaDTO>> findAll() {
		List<Comanda> list = service.findAll();
		List<ComandaDTO> listDTO = list.stream().map(obj -> new ComandaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<ComandaDTO> find(@PathVariable Long id) {
		Comanda comanda = service.findbyId(id);
		ComandaDTO dto = new ComandaDTO(comanda);
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ComandaNewDTO dto) {
		Comanda comanda = service.FromDTO(dto);
		comanda.getDescontovl();
		comanda.getTotalvl();
		comanda = service.insert(comanda);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(comanda.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ComandaUpdDTO dto, @PathVariable Long id) {
		Comanda comanda = service.findbyId(id);
		Comanda comandaUpd = service.FromDTO(dto);
		comandaUpd.setId(id);
		comanda.setDtabertura(dto.getDtabertura());
		comanda.setDtfechamento(dto.getDtfechamento());
//		if (dto.getItens().size()>0) {
//			comanda.getItens().addAll(dto.getItens()));
//		}
//		if (dto.getPags().size()>0) {
//			comanda.getPagtos().addAll(dto.getPags());
//		}
		comandaUpd = service.update(comandaUpd);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
