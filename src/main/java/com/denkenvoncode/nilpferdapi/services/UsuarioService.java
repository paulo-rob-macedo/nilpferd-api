package com.denkenvoncode.nilpferdapi.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Usuario;
import com.denkenvoncode.nilpferdapi.domain.enums.UsuarioPerfilEnum;
import com.denkenvoncode.nilpferdapi.domain.enums.UsuarioStatusEnum;
import com.denkenvoncode.nilpferdapi.dto.UsuarioDTO;
import com.denkenvoncode.nilpferdapi.dto.UsuarioNewDTO;
import com.denkenvoncode.nilpferdapi.repositories.UsuarioRepository;
import com.denkenvoncode.nilpferdapi.security.UsuarioLogin;
import com.denkenvoncode.nilpferdapi.services.exceptions.AuthorizationException;
import com.denkenvoncode.nilpferdapi.services.exceptions.DataIntegrityException;
import com.denkenvoncode.nilpferdapi.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	

	public List<Usuario> findAll() {
		return repository.findAll();
	}

	public List<Usuario> findAllOrderByNome() {
		return repository.findAllByOrderByNome();
	}

	public Usuario findbyId(Long id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto nao encontrado - id:" + id + " , classe :" + Usuario.class.getName()));
		// return usuario.get();
		// return usuario.orElseThrow(() -> new ObjectNotFoundException(
		// "Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}

	public Usuario findByEmail(String email) {
		UsuarioLogin usuarioLogin=UsuarioLoginService.authenticated();
		if (usuarioLogin==null || ! usuarioLogin.hasRole(UsuarioPerfilEnum.Admin)
				&& ! email.equals(usuarioLogin.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
		Usuario usuario=repository.findByEmail(email);
		if (usuario==null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Email: " + usuarioLogin.getUsername() + ", Tipo: " + Usuario.class.getName());
		}
		return usuario;
	}
	
	@Transactional
	public Usuario insert(Usuario usuario) {
		usuario.setId(null);
		usuario = repository.save(usuario);
		return usuario;
	}

	public Usuario update(Usuario usuario) {
		Usuario usuarioUpd = findbyId(usuario.getId());
		if (usuario.getNome() != null) {
			usuarioUpd.setNome(usuario.getNome());
		}
		if (usuario.getApelido() != null) {
			usuarioUpd.setApelido(usuario.getApelido());
		}
		if (usuario.getEmail() != null) {
			usuarioUpd.setEmail(usuario.getEmail());
		}
		usuarioUpd = repository.save(usuarioUpd);
		return usuarioUpd;
	}

	public void delete(Long id) {
		findbyId(id);
		try {
			repository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir pois ha registros relacionados!");
		}
	}

	public Usuario fromDTO(UsuarioDTO dto) {
		Usuario usuario=new Usuario(dto.getNome(), dto.getApelido(), dto.getEmail(),
				UsuarioStatusEnum.Ativo);
		usuario.setId(dto.getId());
		return usuario;
	}

	public Usuario fromDTO(UsuarioNewDTO dto) {
		Usuario usuario=new Usuario(dto.getNome(), dto.getApelido(), dto.getEmail(),
				UsuarioStatusEnum.Ativo);
		usuario.setSenha(dto.getSenha());
		return usuario;
	}

}