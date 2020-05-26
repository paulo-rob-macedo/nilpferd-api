package com.denkenvoncode.nilpferdapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Cliente;

@Repository
public interface ClienteRepository  extends JpaRepository<Cliente, Long>{

	@Transactional(readOnly=true)
	public List<Cliente> findAll();
	
	@Transactional(readOnly=true)
	public Cliente findByEmail(String email);
}
