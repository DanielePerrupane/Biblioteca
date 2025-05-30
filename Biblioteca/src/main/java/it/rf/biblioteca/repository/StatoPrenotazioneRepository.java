package it.rf.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.StatoPrenotazione;

@Repository
public interface StatoPrenotazioneRepository extends JpaRepository<StatoPrenotazione, Integer> {

}
