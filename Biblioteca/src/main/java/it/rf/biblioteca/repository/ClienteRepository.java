package it.rf.biblioteca.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.rf.biblioteca.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, String>{
	
	public Integer countByCfCliente(String cfCliente);
	public Integer countByUsernameCliente(String usernameCliente);
	public Optional<Cliente> findByUsernameCliente(String usernameCliente);

}
