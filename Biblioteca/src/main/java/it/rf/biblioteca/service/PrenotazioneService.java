package it.rf.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.biblioteca.DTO.PrenotazioneDTO;
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
	
	public List<Prenotazione> prendiListaPrenotazioni() {
		return this.pr.findAll();
	}
	
	public List<PrenotazioneDTO> prendiListaPrenotazioniDTO() {
		System.out.println("service");
		return this.pr.prendiListaPrenotazioni();
	}
	
	public Prenotazione trovaPrenotazione(Integer idPrenotazione)
	{
		return this.pr.findById(idPrenotazione).get();
	}
	
	public void cancellaPrenotazione(Integer idPrenotazione)
	{
		Prenotazione p = pr.findById(idPrenotazione).get();
		pr.delete(p);
		
	}

}
