package it.uniroma3.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import it.uniroma3.spring.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByName(String name);
	User findById(Long id);
	List<User> findAll();
	User findByUsername(String username);
}
