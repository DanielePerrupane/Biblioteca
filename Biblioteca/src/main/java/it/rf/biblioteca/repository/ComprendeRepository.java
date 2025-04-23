package it.rf.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Comprende;

@Repository
public interface ComprendeRepository extends JpaRepository<Comprende, Integer> {

}
