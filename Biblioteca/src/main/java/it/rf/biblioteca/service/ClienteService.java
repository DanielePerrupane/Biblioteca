package it.rf.biblioteca.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.rf.biblioteca.model.Cliente;
import it.rf.biblioteca.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository cr;
	
	public Cliente registraCliente(Cliente c)
	{
		return this.cr.save(c);
	}
	
	public void modificaCliente(Cliente c)
	{
		cr.save(c);
	}
	
	public Integer countUser(String usernameCliente)
	{
		
		
		return this.cr.countByUsernameCliente(usernameCliente);	
		
	}
	
	public Integer countCf(String cfCliente)
	{
		return this.cr.countByCfCliente(cfCliente);		
	}
	
	public List<Cliente> prendiListaClienti() {
		return this.cr.findAll();
	}
	
	public Optional<Cliente> trovaByUsername(String usernameCliente)
	{
		String ciao = "ciao";
		return this.cr.findByUsernameCliente(usernameCliente);
		
	}

}
