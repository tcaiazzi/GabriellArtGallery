package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Permission;

public interface PermissionRepository  extends CrudRepository<Permission, Long>{
	List<Permission> findAll();
	
	List<Permission> findByRole(String role);
	
	
}
