package it.rf.biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Comprende")
public class Comprende {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idComprende;
	@Column
	private String note;
	@Column
	private Boolean riconsegnato;
	
	@ManyToOne
	@JoinColumn(name="idLibro")
	private Libro libro;
	@ManyToOne
	@JoinColumn(name="idPrenotazione")
	private Prenotazione prenotazione;
	
	public Comprende() {
		
	}
	
	public Comprende(String note, Boolean riconsegnato, Libro libro, Prenotazione prenotazione) {
		
		this.note=note;
		this.riconsegnato=riconsegnato;
		this.libro=libro;
		this.prenotazione=prenotazione;
		
	}

	public Comprende(Integer idComprende, String note, Boolean riconsegnato, Libro libro, Prenotazione prenotazione) {
		super();
		this.idComprende = idComprende;
		this.note = note;
		this.riconsegnato = riconsegnato;
		this.libro = libro;
		this.prenotazione = prenotazione;
	}

	public Integer getIdComprende() {
		return idComprende;
	}

	public void setIdComprende(Integer idComprende) {
		this.idComprende = idComprende;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Boolean getRiconsegnato() {
		return riconsegnato;
	}

	public void setRiconsegnato(Boolean riconsegnato) {
		this.riconsegnato = riconsegnato;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
	
	
}
