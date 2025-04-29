package it.rf.biblioteca.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.biblioteca.model.Prenotazione;
import it.rf.biblioteca.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {
	
	@Autowired
	private PrenotazioneRepository pr;
	
	public void registraPrenotazione(Prenotazione p)
	{
		this.pr.save(p);
	}

}
