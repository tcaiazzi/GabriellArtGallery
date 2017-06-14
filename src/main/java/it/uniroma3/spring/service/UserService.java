package it.uniroma3.spring.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.spring.model.Permission;
import it.uniroma3.spring.model.User;
import it.uniroma3.spring.repository.PermissionRepository;
import it.uniroma3.spring.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PermissionRepository permissionRepository;
	
	 @Autowired
	 private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Transactional
	public void add(final User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		this.userRepository.save(user);
		Permission permission = new Permission(user.getUsername(), user.getId(), "ADMIN");
		permissionRepository.save(permission);
        userRepository.save(user);
		
	}
	
	
	
}
