package it.rf.biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.rf.biblioteca.DTO.LoginRequestDTO;
import it.rf.biblioteca.model.Cliente;
import it.rf.biblioteca.service.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService cs;
	
	@PostMapping("/login")
	public ResponseEntity<String> effettuaLogin(@RequestBody LoginRequestDTO loginRequest)
	{
		System.out.println(loginRequest.getUser());
		System.out.println(loginRequest.getPsw());
		Boolean pswErrata = false;
		
		List<Cliente> listaClienti = cs.prendiListaClienti();
		
		if(cs.trovaByUsername(loginRequest.getUser()).isPresent()) {
			if(loginRequest.getPsw().equals(cs.trovaByUsername(loginRequest.getUser()).get().getPswCliente()))
			{
				System.out.println("effettuo il login");
				//Response OK
				return new ResponseEntity<String>("LOGIN EFFETTUATO",HttpStatus.OK);
			}
			else
			{
				System.out.println("psw errata");
				//Response BAD REQUEST
				return new ResponseEntity<String>("PASSWORD ERRATA",HttpStatus.BAD_REQUEST);
			}
		}
		else {
			//non ci sono user corrispondenti
			System.out.println("no username compatibili");
			//Response BAD REQUEST
			return new ResponseEntity<String>("USERNAME NON ESISTENTE",HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/registraCliente")
	public ResponseEntity<Cliente> registraCliente(@RequestBody Cliente c) {
//		System.out.println("nome: "+c.getNomeCliente());
//		System.out.println("cognome: "+c.getCognomeCliente());
//		System.out.println("cf: "+c.getCfCliente());
//		System.out.println("email: "+c.getEmailCliente());
//		System.out.println("ntel: "+c.getNumTelCliente());
//		System.out.println("user: "+c.getUsernameCliente());
//		System.out.println("psw: "+c.getPswCliente()); 
		
		if(cs.countCf(c.getCfCliente()).equals(0) && cs.countUser(c.getUsernameCliente()).equals(0))
		{
			
			if(!cs.registraCliente(c).equals(null))
			{
				return new ResponseEntity<Cliente>(c,HttpStatus.CREATED);
			}else
			{
				return new ResponseEntity<Cliente>(c,HttpStatus.NO_CONTENT);
			}
			
		}
		else
		{
			return new ResponseEntity<Cliente>(c,HttpStatus.BAD_REQUEST);
		}
	}

}
