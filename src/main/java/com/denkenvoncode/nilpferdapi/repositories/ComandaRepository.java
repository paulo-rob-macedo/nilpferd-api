package com.denkenvoncode.nilpferdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.denkenvoncode.nilpferdapi.domain.Comanda;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long>{

	
}
