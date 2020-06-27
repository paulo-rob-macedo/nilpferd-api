package com.denkenvoncode.nilpferdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.denkenvoncode.nilpferdapi.domain.ComandaIT;
import com.denkenvoncode.nilpferdapi.domain.ComandaITPK;

@Repository
public interface ComandaITRepository extends JpaRepository<ComandaIT, ComandaITPK>{

//	@Transactional(readOnly=true)
//	public List<ComandaIT> findByComanda(Comanda comanda);
	
}
