package com.denkenvoncode.nilpferdapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Prod;
import com.denkenvoncode.nilpferdapi.domain.Unid;
import com.denkenvoncode.nilpferdapi.domain.enums.ProdStatusEnum;
import com.denkenvoncode.nilpferdapi.dto.ProdNewDTO;
import com.denkenvoncode.nilpferdapi.dto.ProdUpdDTO;
import com.denkenvoncode.nilpferdapi.repositories.ProdRepository;
import com.denkenvoncode.nilpferdapi.services.exceptions.DataIntegrityException;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;


@Service
public class ProdService {

	@Autowired
	private ProdRepository repository;
	
	@Autowired
	private UnidService unidService;
	
	public List<Prod> findAll(){
		return repository.findAll();
	}
	
	public List<Prod> findAllByOrderDescr(){
		return repository.findAllByOrderByDescr();
	}
	
	public Prod findbyId(Long id) {
		Optional<Prod> prod=repository.findById(id);
		return prod.orElseThrow(()-> new ObjectNotFoundException("Objeto nao encontrado - id:"+id
				+" , classe :"+Prod.class.getName()));
		//return prod.get();
		//return usuario.orElseThrow(() -> new ObjectNotFoundException(
		//	
	}
	
	public Page<Prod> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repository.findAll(pageRequest);
	}
	
	@Transactional
	public Prod insert(Prod prod) {
		prod.setId(null);
		if (prod.getUnidvenda()==null) {
			throw new DataIntegrityException("Informe a Unidade de Venda do Produto!");
		}
		if (prod.getUnidcompra()==null) {
			throw new DataIntegrityException("Informe a Unidade de Compra do Produto!");
		}
		prod = repository.save(prod);
		return prod;
	}
	
	public Prod update(Prod prod) {
		Prod prodUpd = repository.save(prod);
		return prodUpd;
	}

	public void delete(Long id) {
		findbyId(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir pois ha registros relacionados!");
		}
	}
	
	public Prod FromDTO(ProdNewDTO dto) {
		Unid unidVenda=unidService.findbyId(dto.getUnidvendaid());
		Unid unidCompra=unidService.findbyId(dto.getUnidcompraid());
		Prod prod=new Prod(dto.getDescr(),dto.getPrecovenda(),dto.getPrecocompra(),unidVenda,unidCompra,ProdStatusEnum.Ativo);
		return prod;
	}

	public Prod FromDTO(ProdUpdDTO dto) {
		Unid unidVenda=unidService.findbyId(dto.getUnidvendaid());
		Unid unidCompra=unidService.findbyId(dto.getUnidcompraid());
		Prod prod=new Prod(dto.getDescr(),dto.getPrecovenda(),dto.getPrecocompra(),unidVenda,unidCompra,ProdStatusEnum.Ativo);
		return prod;		
	}
}
