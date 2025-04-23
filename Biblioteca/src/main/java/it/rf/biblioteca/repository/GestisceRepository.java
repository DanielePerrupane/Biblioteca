package it.rf.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Gestisce;

@Repository
public interface GestisceRepository extends JpaRepository<Gestisce, Integer>{

}
