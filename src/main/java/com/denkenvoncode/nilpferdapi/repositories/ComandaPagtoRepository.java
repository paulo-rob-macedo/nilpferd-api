package com.denkenvoncode.nilpferdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.denkenvoncode.nilpferdapi.domain.ComandaPagto;

@Repository
public interface ComandaPagtoRepository extends JpaRepository<ComandaPagto, Long>{

//	@Query("select p from ComandaPagto p where p.comandaid=:comandaid")
//	public Optional<ComandaPagto>  ListAllComanda(@Param("comandaid") Long comandaid);
	
}
