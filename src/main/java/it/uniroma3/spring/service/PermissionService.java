package it.uniroma3.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import it.uniroma3.spring.model.Permission;

import it.uniroma3.spring.repository.PermissionRepository;

@Service
public class PermissionService {
	@Autowired
	private PermissionRepository permissionRepository;
	
	@Transactional
	public void add(final Permission permission){
		this.permissionRepository.save(permission);
	}
	
	@Transactional
	public List<Permission> findAll() {
		// TODO Auto-generated method stub
		return permissionRepository.findAll();
	}
	
	@Transactional
	public List<Permission> findAllUsers() {
		// TODO Auto-generated method stub
		return permissionRepository.findByRole("USER");
	}
	
	@Transactional
	public void deletePermission(Long id){
		this.permissionRepository.delete(id);
	}
}
