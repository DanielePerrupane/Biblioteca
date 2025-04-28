package it.rf.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rf.biblioteca.DTO.LoginRequestDTO;
import it.rf.biblioteca.model.Operatore;
import it.rf.biblioteca.service.OperatoreService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Operatore")
public class OperatoreController {

	@Autowired
	private OperatoreService os;
	
	
	
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
