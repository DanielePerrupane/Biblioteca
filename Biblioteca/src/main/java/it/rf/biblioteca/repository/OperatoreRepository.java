package it.rf.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Operatore;

@Repository
public interface OperatoreRepository extends JpaRepository<Operatore, String>{
	
	public Integer countByUsernameOperatore(String usernameOperatore);
	public Integer countByCfOperatore(String cfOperatore);
	public Optional<Operatore> findByUsernameOperatore(String usernameOperatore);
	
	public Optional<Operatore> findByCfOperatore(String cfOperatore);

}
