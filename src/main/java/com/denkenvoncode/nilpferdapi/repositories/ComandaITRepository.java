package com.denkenvoncode.nilpferdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.denkenvoncode.nilpferdapi.domain.ComandaIT;
import com.denkenvoncode.nilpferdapi.domain.ComandaITPK;

public interface ComandaITRepository extends JpaRepository<ComandaIT, ComandaITPK>{

}
