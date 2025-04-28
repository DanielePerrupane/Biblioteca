package it.rf.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.biblioteca.model.Operatore;
import it.rf.biblioteca.repository.OperatoreRepository;

@Service
public class OperatoreService {
	
	@Autowired
	private OperatoreRepository or;
	
	public Integer controllaUsername(String username)
	{
		return this.or.countByUsernameOperatore(username);
	}
	
	public Integer controllaCf(String cfOperatore)
	{
		return this.or.countByCfOperatore(cfOperatore);
	}
	
	public void registraOperatore(Operatore o)
	{
		this.or.save(o);
	}
	
	public Optional<Operatore> trovaOperatore(String usernameOperatore)
	{
		return this.or.findByUsernameOperatore(usernameOperatore);
	}
	
	public Optional<Operatore> trovaOperatoreByCf(String cfOperatore)
	{
		return this.or.findByCfOperatore(cfOperatore);
	}
	
	

}
