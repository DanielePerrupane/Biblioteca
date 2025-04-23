package it.rf.biblioteca.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Cliente")
public class Cliente {
	
	@Id
	@Column
	private String cfCliente;
	@Column
	private String cognomeCliente;
	@Column
	private String emailCliente;
	@Column
	private String nomeCliente;
	@Column
	private String numTelCliente;
	@Column
	private String pswCliente;
	@Column
	private String usernameCliente;
	
	@OneToMany(mappedBy="idPrenotazione")
	private List<Prenotazione> listaPrenotazione;
	
	public Cliente() {
		
	}

	public Cliente(String cfCliente, String cognomeCliente, String emailCliente, String nomeCliente,
			String numTelCliente, String pswCliente, String usernameCliente, List<Prenotazione> listaPrenotazione) {
		super();
		this.cfCliente = cfCliente;
		this.cognomeCliente = cognomeCliente;
		this.emailCliente = emailCliente;
		this.nomeCliente = nomeCliente;
		this.numTelCliente = numTelCliente;
		this.pswCliente = pswCliente;
		this.usernameCliente = usernameCliente;
		this.listaPrenotazione = listaPrenotazione;
	}

	public String getCfCliente() {
		return cfCliente;
	}

	public void setCfCliente(String cfCliente) {
		this.cfCliente = cfCliente;
	}

	public String getCognomeCliente() {
		return cognomeCliente;
	}

	public void setCognomeCliente(String cognomeCliente) {
		this.cognomeCliente = cognomeCliente;
	}

	public String getEmailCliente() {
		return emailCliente;
	}

	public void setEmailCliente(String emailCliente) {
		this.emailCliente = emailCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getNumTelCliente() {
		return numTelCliente;
	}

	public void setNumTelCliente(String numTelCliente) {
		this.numTelCliente = numTelCliente;
	}

	public String getPswCliente() {
		return pswCliente;
	}

	public void setPswCliente(String pswCliente) {
		this.pswCliente = pswCliente;
	}

	public String getUsernameCliente() {
		return usernameCliente;
	}

	public void setUsernameCliente(String usernameCliente) {
		this.usernameCliente = usernameCliente;
	}

	public List<Prenotazione> getListaPrenotazione() {
		return listaPrenotazione;
	}

	public void setListaPrenotazione(List<Prenotazione> listaPrenotazione) {
		this.listaPrenotazione = listaPrenotazione;
	}
	
	

}
