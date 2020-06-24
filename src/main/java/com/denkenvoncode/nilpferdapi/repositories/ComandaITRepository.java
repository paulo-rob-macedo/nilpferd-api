package com.denkenvoncode.nilpferdapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.ComandaIT;
import com.denkenvoncode.nilpferdapi.domain.ComandaITPK;

public interface ComandaITRepository extends JpaRepository<ComandaIT, ComandaITPK>{

	@Transactional(readOnly=true)
	public List<ComandaIT> findbyComandaid(Long comandaid);
}
