package it.rf.biblioteca.DTO;

import java.sql.Date;
import java.time.LocalDate;


public class PrenotazioneDTO {
	
	private Integer idPrenotazione;
	private Date dataInizio; //pren
	private Date dataFine; //pren
	private Double acconto; //pren
	private Double totale; //pren
	private String username; //pren - > cfCliente
	private String titoloLibro; //libro
	
	
	
	public Integer getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(Integer idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	public String getTitoloLibro() {
		return titoloLibro;
	}
	public void setTitoloLibro(String titoloLibro) {
		this.titoloLibro = titoloLibro;
	}
	public Date getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}
	public Date getDataFine() {
		return dataFine;
	}
	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}
	public Double getAcconto() {
		return acconto;
	}
	public void setAcconto(Double acconto) {
		this.acconto = acconto;
	}
	public Double getTotale() {
		return totale;
	}
	public void setTotale(Double totale) {
		this.totale = totale;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	public PrenotazioneDTO() {
		
	}
	public PrenotazioneDTO(Integer idPrenotazione, Date dataInizio, Date dataFine, Double acconto, Double totale,
			String username, String titoloLibro) {
		super();
		this.idPrenotazione = idPrenotazione;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.acconto = acconto;
		this.totale = totale;
		this.username = username;
		this.titoloLibro = titoloLibro;
	}
	
	
	
}
