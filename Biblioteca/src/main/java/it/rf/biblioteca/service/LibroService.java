package it.rf.biblioteca.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.rf.biblioteca.model.Libro;
import it.rf.biblioteca.repository.LibroRepository;

@Service
public class LibroService {
	
	@Autowired
	private LibroRepository lr;
	
	public ResponseEntity<Libro> eliminaLibro(Integer idLibro)
	{
		
		this.lr.deleteById(idLibro);
		System.out.println("service");
		return new ResponseEntity<Libro>(HttpStatus.OK);
	}
	
	public ResponseEntity<Libro> cercaLibro(String titolo)
	{	
		if(lr.findByTitoloLibro(titolo).isPresent())
		{
			return new ResponseEntity<Libro>(this.lr.findByTitoloLibro(titolo).get(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<Libro>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	public ResponseEntity<Libro> modificaLibro(Libro l)
	{
		if(!lr.findByTitoloLibro(l.getTitoloLibro()).isPresent())
		{
			this.lr.save(l);
			return new ResponseEntity<Libro>(HttpStatus.OK);
		}
		else 
		{
			return new ResponseEntity<Libro>(HttpStatus.NO_CONTENT);
		}
		
	}
	
	public ResponseEntity<Libro> registraLibro(Libro l)
	{
		if(!lr.findByTitoloLibro(l.getTitoloLibro()).isPresent())
		{
			System.out.println("non duplicato");
			//posso inserire il nuovo libro
			this.lr.save(l);
			return new ResponseEntity<Libro>(l,HttpStatus.CREATED);
		}
		else {
			//titolo già presente
			System.out.println("duplicato");
			return new ResponseEntity<Libro>(HttpStatus.NO_CONTENT);
		}
	}

}
