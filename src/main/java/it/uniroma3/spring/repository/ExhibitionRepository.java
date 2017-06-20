package it.uniroma3.spring.repository;




import org.springframework.data.repository.CrudRepository;
import it.uniroma3.spring.model.Exhibition;


public interface ExhibitionRepository extends CrudRepository<Exhibition, Long> {
	
}
