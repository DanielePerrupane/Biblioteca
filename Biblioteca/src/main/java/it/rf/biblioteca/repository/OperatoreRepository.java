package it.rf.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Operatore;

@Repository
public interface OperatoreRepository extends JpaRepository<Operatore, String>{

}
