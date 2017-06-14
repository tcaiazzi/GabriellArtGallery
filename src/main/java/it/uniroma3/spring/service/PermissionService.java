package it.uniroma3.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Permission;

import it.uniroma3.spring.repository.PermissionRepository;


public class PermissionService {
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Transactional
	public void add(final Permission permission){
		this.permissionRepository.save(permission);
	}
}
