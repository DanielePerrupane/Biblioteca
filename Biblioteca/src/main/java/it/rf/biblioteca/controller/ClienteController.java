package it.rf.biblioteca.controller;

import java.util.List;
import java.util.Optional;

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
import it.rf.biblioteca.model.Cliente;
import it.rf.biblioteca.service.ClienteService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/Cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService cs;
	
	@PostMapping("/login")
	public ResponseEntity<Cliente> effettuaLogin(@RequestBody LoginRequestDTO loginRequest)
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
				Cliente c = cs.trovaByUsername(loginRequest.getUser()).get();
				return new ResponseEntity<Cliente>(c,HttpStatus.OK);
			}
			else
			{
				System.out.println("psw errata");
				//Response BAD REQUEST
				return new ResponseEntity<Cliente>(HttpStatus.UNAUTHORIZED);
			}
		}
		else {
			//non ci sono user corrispondenti
			System.out.println("no username compatibili");
			//Response BAD REQUEST
			return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PostMapping("/registraCliente")
	public ResponseEntity<Cliente> registraCliente(@RequestBody Cliente c) {
		
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
	
	
	@GetMapping("/visualizzoDati/{username}")
	public ResponseEntity<Cliente> visualizzoDati(@PathVariable String username)
	{
		System.out.println("nome: " + username);
		Optional<Cliente> c = cs.trovaByUsername(username);
		if(c.isPresent()) {
			return new ResponseEntity<Cliente>(c.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@PutMapping("/modificaCliente")
	public ResponseEntity<Cliente> modificaCliente(@RequestBody Cliente c)
	{
		System.out.println(c.getNomeCliente());
		System.out.println(c.getNumTelCliente());
		if(!cs.modificaCliente(c).equals(null))
		{
			return new ResponseEntity<Cliente>(c,HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<Cliente>(c,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
