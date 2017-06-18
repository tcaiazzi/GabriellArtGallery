package it.uniroma3.spring.repository;

import java.util.List;

import javax.persistence.NamedQuery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import it.uniroma3.spring.model.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, Long>,CrudRepository<Reservation, Long>{
	
	//@Query(value = "SELECT r FROM Reservations r WHERE r.exhibition_name=?")
	List<Reservation> findByExhibition(String ex_name);
}
