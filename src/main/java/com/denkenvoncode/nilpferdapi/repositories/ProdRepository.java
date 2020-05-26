package com.denkenvoncode.nilpferdapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Prod;

@Repository
public interface ProdRepository extends JpaRepository<Prod, Long>{

	@Transactional(readOnly=true)
	public List<Prod> findAllByOrderByDescr();
	
	@Transactional(readOnly=true)
	public List<Prod> findAll();
}
