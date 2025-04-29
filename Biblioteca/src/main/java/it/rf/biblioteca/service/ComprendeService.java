package it.rf.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.biblioteca.model.Comprende;
import it.rf.biblioteca.repository.ComprendeRepository;

@Service
public class ComprendeService {
	
	@Autowired
	private ComprendeRepository cr;
	
	public void registraComprende(Comprende c)
	{
		this.cr.save(c);
	}
	

}
