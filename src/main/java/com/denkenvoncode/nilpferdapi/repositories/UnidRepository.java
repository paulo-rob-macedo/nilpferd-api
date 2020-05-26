package com.denkenvoncode.nilpferdapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.denkenvoncode.nilpferdapi.domain.Unid;


@Repository
public interface UnidRepository extends JpaRepository<Unid, Long>{

	@Transactional(readOnly=true)
	public List<Unid> findAllByOrderByDescr();
	
	@Transactional(readOnly=true)
	public List<Unid> findAll();

}
