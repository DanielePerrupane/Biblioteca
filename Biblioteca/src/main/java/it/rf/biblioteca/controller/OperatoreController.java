package it.rf.biblioteca.controller;

import java.time.LocalDate;
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

import it.rf.biblioteca.DTO.LoginRequestDTO;
import it.rf.biblioteca.DTO.PrenotazioneDTO;
import it.rf.biblioteca.model.Cliente;
import it.rf.biblioteca.model.Comprende;
import it.rf.biblioteca.model.Libro;
import it.rf.biblioteca.model.Operatore;
import it.rf.biblioteca.model.Prenotazione;
import it.rf.biblioteca.model.StatoPrenotazione;
import it.rf.biblioteca.service.ClienteService;
import it.rf.biblioteca.service.ComprendeService;
import it.rf.biblioteca.service.LibroService;
import it.rf.biblioteca.service.OperatoreService;
import it.rf.biblioteca.service.PrenotazioneService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Operatore")
public class OperatoreController {

	@Autowired
	private OperatoreService os;
	@Autowired
	private PrenotazioneService ps;
	@Autowired
	private ComprendeService cs;
	@Autowired
	private LibroService ls;
	@Autowired
	private ClienteService cls;
	@Autowired
	private ComprendeService cmps;
	
	@PutMapping("/modificaPrenotazione")
	public ResponseEntity<Prenotazione> modificaPrenotazione(@RequestBody PrenotazioneDTO pDto)
	{
		System.out.println("----------------------------------modifica Prenotazione");
		System.out.println("--------------username: "+pDto.getUsername()); //mi arriva il cf
		System.out.println("--------------data inizio: "+pDto.getDataInizio()); //mi arriva il cf
		System.out.println("--------------data fine: "+pDto.getDataFine()); //mi arriva il cf
		System.out.println("--------------totale: "+pDto.getTotale()); //mi arriva il cf
		System.out.println("--------------acconto: "+pDto.getAcconto()); //mi arriva il cf
		System.out.println("-------------id:" + pDto.getIdPrenotazione());
		System.out.println("--------------titolo libro arrivato: " + pDto.getTitoloLibro());
		
		Libro libro = ls.trovaLibro(pDto.getTitoloLibro());
		System.out.println("----------------------------------------titolo libro: " + libro.getTitoloLibro());
		
		//fare ricerca x cf
		Cliente cliente = cls.trovaByCf(pDto.getUsername());
		StatoPrenotazione statoPrenotazione = new StatoPrenotazione(1,"in corso");
		LocalDate dataInizio = pDto.getDataInizio().toLocalDate();
		LocalDate dataFine = pDto.getDataFine().toLocalDate();
		Prenotazione p = new Prenotazione(pDto.getIdPrenotazione(),pDto.getAcconto(),dataInizio,dataFine,pDto.getTotale(),cliente,statoPrenotazione);
		
		ps.registraPrenotazione(p);
		System.out.println("---------------------------------------registrazione prenotazione");
		//modificare anche il comprende 
		
		
		Comprende c = cmps.trovaComprende(p);
		cmps.modificaLibro(c, libro);
		cmps.registraComprende(c);
		
		
		return new ResponseEntity<Prenotazione>(p,HttpStatus.OK);
	}
	
	
	@DeleteMapping("/eliminaPrenotazione/{idPrenotazione}")
	public ResponseEntity<Prenotazione> eliminaPrenotazione(@PathVariable Integer idPrenotazione)
	{
		System.out.println(idPrenotazione);
		//inserire prima eliminazione di comprende!!
		cs.cancellaComprende(ps.trovaPrenotazione(idPrenotazione));
		
		ps.cancellaPrenotazione(idPrenotazione);
		
		return new ResponseEntity<Prenotazione>(HttpStatus.OK);
		
	}
	
	@GetMapping("/prendiPrenotazioni")
	public ResponseEntity<List<PrenotazioneDTO>> prendiPrenotazioni()
	{
		System.out.println("---------------------chiamata");
		List<PrenotazioneDTO> listaPrenotazioni = ps.prendiListaPrenotazioniDTO();
		
		return new ResponseEntity<List<PrenotazioneDTO>>(listaPrenotazioni, HttpStatus.OK);
		
	}
	
	@PutMapping("/modificaOperatore")
	public ResponseEntity<Operatore> modificaOperatore(@RequestBody Operatore op)
	{
		os.registraOperatore(op);
		return new ResponseEntity<Operatore>(op,HttpStatus.OK);
	}
	
	
	@GetMapping("/cercaOperatore/{cfDaRic}")
	public ResponseEntity<Operatore> cercaOperatore(@PathVariable String cfDaRic)
	{	
		
		if(os.trovaOperatoreByCf(cfDaRic).isPresent())
		{
			//Operatore trovato OK 
			Operatore op = os.trovaOperatoreByCf(cfDaRic).get();
			System.out.println("cfDaRic: "+cfDaRic);
			return new ResponseEntity<Operatore>(op,HttpStatus.OK);
			
		}
		else if(!os.trovaOperatoreByCf(cfDaRic).isPresent())
		{
			//Operatore non trovato NO_CONTENT
			return new ResponseEntity<Operatore>(HttpStatus.NO_CONTENT);
		}
		else 
		{	
			return new ResponseEntity<Operatore>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/login")
	public ResponseEntity<LoginRequestDTO> effettuaLogin(@RequestBody LoginRequestDTO loginRequest)
	{
		System.out.println(loginRequest.getUser());
		System.out.println(loginRequest.getPsw());
		
		
		//trovo l'operatore in base all'username e controllo la psw
		if(os.trovaOperatore(loginRequest.getUser()).isPresent())
		{
			Operatore op = os.trovaOperatore(loginRequest.getUser()).get();
			//controllo la psw 
			if(op.getPswOperatore().equals(loginRequest.getPsw()))
			{
				//effettuo login 200
				return new ResponseEntity<LoginRequestDTO>(loginRequest,HttpStatus.OK);
			}
			else
			{
				//password errata
				return new ResponseEntity<LoginRequestDTO>(HttpStatus.UNAUTHORIZED);
			}
		}
		else 
		{
			//username errato
			return new ResponseEntity<LoginRequestDTO>(HttpStatus.BAD_REQUEST);
			
		}
			
		
		
		
	}
	
	@PostMapping("/registrazione")
	public ResponseEntity<Operatore> effettuaRegistrazione(@RequestBody Operatore o)
	{
		System.out.println(o.getNomeOperatore());
		System.out.println(o.getCognomeOperatore());
		System.out.println(o.getCfOperatore());
		System.out.println(o.getUsernameOperatore());
		System.out.println(o.getPswOperatore());
		System.out.println(o.getCategoriaOperatore());
		
		if(os.controllaCf(o.getCfOperatore()).equals(0))
		{
			if(os.controllaUsername(o.getUsernameOperatore()).equals(0))
			{
				//registro l'operatore 201
				os.registraOperatore(o);
				return new ResponseEntity<Operatore>(o,HttpStatus.CREATED);
				
			}
			else
			{
				//username già presente 204
				return new ResponseEntity<Operatore>(HttpStatus.NO_CONTENT);
			}
		}
		else
		{
			//cf già esistente 400
			return new ResponseEntity<Operatore>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	
	
}
