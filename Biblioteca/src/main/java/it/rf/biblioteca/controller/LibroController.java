package it.rf.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rf.biblioteca.model.Genere;
import it.rf.biblioteca.model.Libro;
import it.rf.biblioteca.service.GenereService;
import it.rf.biblioteca.service.LibroService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Libro")
public class LibroController {
	
	@Autowired
	private GenereService gs;
	@Autowired 
	private LibroService ls;
	
	
	
	@DeleteMapping("/eliminaLibro/{idLibro}")
	public ResponseEntity<Libro> eliminaLibro(@PathVariable Integer idLibro) {
		System.out.println(idLibro);
		return this.ls.eliminaLibro(idLibro);
	}
	
	@PutMapping("/modificaLibro")
	public ResponseEntity<Libro> modificaLibro(@RequestBody Libro l)
	{
		return this.ls.modificaLibro(l);
	}
	
	@GetMapping("/cercaLibro/{titolo}")
	public ResponseEntity<Libro> cercaLibro(@PathVariable String titolo)
	{
		System.out.println(titolo);
		return this.ls.cercaLibro(titolo);
	}
	
	
	@PostMapping("/inserisciLibro")
	public ResponseEntity<Libro> inserisciLibro(@RequestBody Libro l)
	{
//		System.out.println(l.getAutoreLibro());
//		System.out.println(l.getTitoloLibro());
//		System.out.println(l.getCostoGiornaliero());
//		System.out.println(l.getGenere().getNomeGenere());
//		System.out.println(l.getGenere().getDescrizioneGenere());

		return ls.registraLibro(l);
		
		
	}
	
	@GetMapping("/listaGeneri")
	public ResponseEntity<List<Genere>> prendiListaGeneri(){
		
		List<Genere> listaGeneri = gs.prendiListaGeneri();
		
		for(Genere g :listaGeneri) 
		{
			System.out.println(g.getNomeGenere());
		}
		
		return new ResponseEntity<List<Genere>>(listaGeneri, HttpStatus.OK);
		
	}

	@PostMapping("/inserisciGenere")
	public ResponseEntity<Genere> inserisciGenere(@RequestBody Genere genere) {
		
		gs.registraGenere(genere);
		
		return new ResponseEntity<Genere>(genere,HttpStatus.OK);
		
	}
	
	
	
}
