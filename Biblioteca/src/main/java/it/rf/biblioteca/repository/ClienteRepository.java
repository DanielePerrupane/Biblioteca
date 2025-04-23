package it.rf.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{

}
