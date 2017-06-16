package it.uniroma3.spring.repository;

import org.springframework.data.repository.CrudRepository;


import it.uniroma3.spring.model.User;

public interface UserRepository extends CrudRepository<User, Long>{
	User findByName(String name);
	User findById(Long id);
}
