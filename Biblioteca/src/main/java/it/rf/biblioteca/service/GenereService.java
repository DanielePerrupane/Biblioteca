package it.rf.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.rf.biblioteca.model.Genere;
import it.rf.biblioteca.repository.GenereRepository;

@Service
public class GenereService {
	
	@Autowired 
	private GenereRepository gr;
	
	public void registraGenere(Genere gen)
	{
		this.gr.save(gen);
	}
	
	public List<Genere> prendiListaGeneri()
	{
		return this.gr.findAll();
	}

}
