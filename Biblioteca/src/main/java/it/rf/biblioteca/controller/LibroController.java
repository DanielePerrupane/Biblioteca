package it.rf.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rf.biblioteca.model.Genere;
import it.rf.biblioteca.service.GenereService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Libro")
public class LibroController {
	
	@Autowired
	private GenereService gs;

	@PostMapping("/inserisciGenere")
	public void inserisciGenere(@RequestBody Genere genere) {
		System.out.println(genere.getNomeGenere());
		System.out.println(genere.getDescrizioneGenere());
		
		
		
	}
	
}
