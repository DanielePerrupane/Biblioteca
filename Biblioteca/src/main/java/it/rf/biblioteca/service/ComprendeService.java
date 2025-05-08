package it.rf.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.biblioteca.model.Comprende;
import it.rf.biblioteca.model.Libro;
import it.rf.biblioteca.model.Prenotazione;
import it.rf.biblioteca.repository.ComprendeRepository;

@Service
public class ComprendeService {
	
	@Autowired
	private ComprendeRepository cr;
	
	public void registraComprende(Comprende c)
	{
		this.cr.save(c);
	}
	
	public void cancellaComprende(Prenotazione p)
	{
		this.cr.deleteByPrenotazione(p);
	}
	
	public Comprende trovaComprende(Prenotazione p)
	{
		return this.cr.findByPrenotazione(p);
	}
	
	public void modificaLibro(Comprende c, Libro l)
	{
		c.setLibro(l);
	}
	
	
	

}
