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
@Table(name="Gestisce")
public class Gestisce {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGestisce;
	
	
	@ManyToOne
	@JoinColumn(name="cfOperatore")
	private Operatore operatore;
	@ManyToOne
	@JoinColumn(name="idPrenotazione")
	private Prenotazione prenotazione;
	
	public Gestisce() {
		
	}

	public Gestisce(Integer idGestisce, Operatore operatore, Prenotazione prenotazione) {
		super();
		this.idGestisce = idGestisce;
		this.operatore = operatore;
		this.prenotazione = prenotazione;
	}

	public Integer getIdGestisce() {
		return idGestisce;
	}

	public void setIdGestisce(Integer idGestisce) {
		this.idGestisce = idGestisce;
	}

	public Operatore getOperatore() {
		return operatore;
	}

	public void setOperatore(Operatore operatore) {
		this.operatore = operatore;
	}

	public Prenotazione getPrenotazione() {
		return prenotazione;
	}

	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}
	
	
}
