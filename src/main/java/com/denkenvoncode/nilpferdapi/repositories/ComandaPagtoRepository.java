package com.denkenvoncode.nilpferdapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.ComandaPagto;

public interface ComandaPagtoRepository extends JpaRepository<ComandaPagto, Long>{

	@Transactional(readOnly=true)
	public List<ComandaPagto> findbyComandaid(Long comandaid);
}
