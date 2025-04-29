package it.rf.biblioteca.DTO;

import java.time.LocalDate;

public class PrenotazioneDTO {
	
	private LocalDate dataInizio;
	private LocalDate dataFine;
	private Double acconto;
	private Double totale;
	private String username;
	private String titoloLibro;
	
	public String getTitoloLibro() {
		return titoloLibro;
	}
	public void setTitoloLibro(String titoloLibro) {
		this.titoloLibro = titoloLibro;
	}
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	public void setDataInizio(LocalDate dataInizio) {
		this.dataInizio = dataInizio;
	}
	public LocalDate getDataFine() {
		return dataFine;
	}
	public void setDataFine(LocalDate dataFine) {
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
	public PrenotazioneDTO(LocalDate dataInizio, LocalDate dataFine, Double acconto, Double totale, String username, String titolo) {
		super();
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
		this.acconto = acconto;
		this.totale = totale;
		this.username = username;
		this.titoloLibro=titolo;
	}
	
	
}
