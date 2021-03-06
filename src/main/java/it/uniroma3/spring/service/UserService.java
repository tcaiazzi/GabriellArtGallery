package it.uniroma3.spring.service;


import java.util.List;

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
	public void addUser(final User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(false);
		this.userRepository.save(user);
		Permission permission = new Permission(user.getUsername(), user.getId(), "USER"); /**correzione**/
		/*Permission permission = new Permission(user.getUsername(), user.getId(), "USER");*/
		permissionRepository.save(permission);

	}

	@Transactional
	public void addAdmin(final User user){
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setEnabled(true);
		this.userRepository.save(user);
		Permission permission = new Permission(user.getUsername(), user.getId(), "ADMIN");
		permissionRepository.save(permission);


	}
	
	@Transactional
	public User findUserById(Long id){
		return this.userRepository.findById(id);
	}
	
	@Transactional
	public List<User> findAll(){
		return this.userRepository.findAll();
	}



	@Transactional
	public void confirmUserAccount(Long id) {
		User user = findUserById(id);
		user.setEnabled(true);
		this.userRepository.save(user);

	}
	
	@Transactional
	public User findByUsername(String username){
		return this.userRepository.findByUsername(username);
	}
	
	@Transactional
	public void deleteUser(Long id){
		this.userRepository.delete(id);
	}

}
