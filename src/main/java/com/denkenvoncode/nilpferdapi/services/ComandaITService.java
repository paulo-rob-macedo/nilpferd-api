package com.denkenvoncode.nilpferdapi.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.denkenvoncode.nilpferdapi.repositories.ComandaITRepository;

@Service
public class ComandaITService {

	@Autowired
	ComandaITRepository repository;
}
