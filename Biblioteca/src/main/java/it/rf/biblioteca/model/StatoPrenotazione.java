package it.rf.biblioteca.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="StatoPrenotazione")
public class StatoPrenotazione {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idStatoPrenotazione;
	@Column
	private String nomeStatoPrenotazione;
	
	@OneToMany(mappedBy="idPrenotazione")
	private List<Prenotazione> listaPrenotazione;
	
	public StatoPrenotazione() {
		
	}

	public StatoPrenotazione(Integer idStatoPrenotazione, String nomeStatoPrenotazione,
			List<Prenotazione> listaPrenotazione) {
		super();
		this.idStatoPrenotazione = idStatoPrenotazione;
		this.nomeStatoPrenotazione = nomeStatoPrenotazione;
		this.listaPrenotazione = listaPrenotazione;
	}

	public Integer getIdStatoPrenotazione() {
		return idStatoPrenotazione;
	}

	public void setIdStatoPrenotazione(Integer idStatoPrenotazione) {
		this.idStatoPrenotazione = idStatoPrenotazione;
	}

	public String getNomeStatoPrenotazione() {
		return nomeStatoPrenotazione;
	}

	public void setNomeStatoPrenotazione(String nomeStatoPrenotazione) {
		this.nomeStatoPrenotazione = nomeStatoPrenotazione;
	}

	public List<Prenotazione> getListaPrenotazione() {
		return listaPrenotazione;
	}

	public void setListaPrenotazione(List<Prenotazione> listaPrenotazione) {
		this.listaPrenotazione = listaPrenotazione;
	}
	
	
	
}
