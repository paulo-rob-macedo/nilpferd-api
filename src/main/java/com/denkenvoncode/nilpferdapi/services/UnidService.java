package com.denkenvoncode.nilpferdapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Unid;
import com.denkenvoncode.nilpferdapi.dto.UnidDTO;
import com.denkenvoncode.nilpferdapi.repositories.UnidRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.DataIntegrityException;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;

@Service
public class UnidService {

	@Autowired
	private UnidRepository repository;

	public List<Unid> findAll() {
		return repository.findAll();
	}

	public List<Unid> findAllByOrderDescr() {
		return repository.findAllByOrderByDescr();
	}

	public Unid findbyId(Long id) {
		Optional<Unid> unid = repository.findById(id);
		// return unid.orElse(null);
		// return usuario.orElseThrow(() -> new ObjectNotFoundException(
		// "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
		return unid.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado - id:" + id + " , classe :" + Unid.class.getName()));
	}

	@Transactional
	public Unid insert(Unid unid) {
		unid.setId(null);
		unid = repository.save(unid);
		return unid;
	}

	public Unid update(Unid unid) {
		Unid unidUpd = findbyId(unid.getId());
		unidUpd.setDescr(unid.getDescr());
		unidUpd.setSigla(unid.getSigla());
		unidUpd.setQtdec(unid.getQtdec());
		return repository.save(unidUpd);
	}

	public void delete(Long id) {
		findbyId(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir pois ha produtos relacionados!");
		}
	}

	public Unid fromDTO(UnidDTO dto) {
		Unid unid=new Unid(dto.getDescr(), dto.getSigla(), dto.getQtdec());
		unid.setId(dto.getId());
		return unid;
	}
}
