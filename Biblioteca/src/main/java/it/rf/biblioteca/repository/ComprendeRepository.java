package it.rf.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Comprende;
import it.rf.biblioteca.model.Prenotazione;
import jakarta.transaction.Transactional;

@Repository
public interface ComprendeRepository extends JpaRepository<Comprende, Integer> {

	@Transactional
	public void deleteByPrenotazione(Prenotazione prenotazione);
	
	public Comprende findByPrenotazione(Prenotazione prenotazione);
	
}
