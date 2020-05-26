package com.denkenvoncode.nilpferdapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

	@Transactional(readOnly=true)
	public List<Usuario> findAllByOrderByNome();
	
	@Transactional(readOnly=true)
	public List<Usuario> findAll();
	
	@Transactional(readOnly=true)
	public Usuario findByEmail(String email);
} 
