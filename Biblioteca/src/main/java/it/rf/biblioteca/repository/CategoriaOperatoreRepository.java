package it.rf.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.CategoriaOperatore;

@Repository
public interface CategoriaOperatoreRepository extends JpaRepository<CategoriaOperatore, Integer>{

}
