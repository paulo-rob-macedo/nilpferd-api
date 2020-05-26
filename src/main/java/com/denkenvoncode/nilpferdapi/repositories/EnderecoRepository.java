package com.denkenvoncode.nilpferdapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.denkenvoncode.nilpferdapi.domain.Usuario;

@Repository
public interface EnderecoRepository  extends JpaRepository<Usuario, Long>{

}
