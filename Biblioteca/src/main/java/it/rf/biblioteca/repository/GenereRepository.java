package it.rf.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Genere;

@Repository
public interface GenereRepository extends JpaRepository<Genere, Integer>{

}
