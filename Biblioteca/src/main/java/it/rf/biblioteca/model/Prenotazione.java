package it.rf.biblioteca.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Prenotazione")
public class Prenotazione {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPrenotazione;
	@Column
	private Double acconto;
	@Column
	private LocalDate dataFinePrenotazione;
	@Column
	private LocalDate dataInizioPrenotazione;
	@Column
	private Double totale;
	
	
	@ManyToOne
	@JoinColumn(name="cfCliente")
	private Cliente cliente;
	@ManyToOne
	@JoinColumn(name="idStatoPrenotazione")
	private StatoPrenotazione statoPrenotazione;
	@OneToMany(mappedBy="idComprende")
	private List<Comprende> listaComprende;
	
	public Prenotazione() {
		
	}
	
	public Prenotazione(Double acconto, LocalDate dataInizio, LocalDate dataFine, Double totale, Cliente cliente, StatoPrenotazione statoPrenotazione) {
		this.acconto=acconto;
		this.dataInizioPrenotazione=dataInizio;
		this.dataFinePrenotazione=dataFine;
		this.totale=totale;
		this.cliente=cliente;
		this.statoPrenotazione=statoPrenotazione;
	}
	
	public Prenotazione(Integer idPrenotazione, Double acconto, LocalDate dataInizio, LocalDate dataFine, Double totale, Cliente cliente, StatoPrenotazione statoPrenotazione) {
		this.idPrenotazione=idPrenotazione;
		this.acconto=acconto;
		this.dataInizioPrenotazione=dataInizio;
		this.dataFinePrenotazione=dataFine;
		this.totale=totale;
		this.cliente=cliente;
		this.statoPrenotazione=statoPrenotazione;
	}

	public Prenotazione(Integer idPrenotazione, Double acconto, LocalDate dataFinePrenotazione,
			LocalDate dataInizioPrenotazione, Double totale, Cliente cliente, StatoPrenotazione statoPrenotazione,
			List<Comprende> listaComprende) {
		super();
		this.idPrenotazione = idPrenotazione;
		this.acconto = acconto;
		this.dataFinePrenotazione = dataFinePrenotazione;
		this.dataInizioPrenotazione = dataInizioPrenotazione;
		this.totale = totale;
		this.cliente = cliente;
		this.statoPrenotazione = statoPrenotazione;
		this.listaComprende = listaComprende;
	}

	public Integer getIdPrenotazione() {
		return idPrenotazione;
	}

	public void setIdPrenotazione(Integer idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}

	public Double getAcconto() {
		return acconto;
	}

	public void setAcconto(Double acconto) {
		this.acconto = acconto;
	}

	public LocalDate getDataFinePrenotazione() {
		return dataFinePrenotazione;
	}

	public void setDataFinePrenotazione(LocalDate dataFinePrenotazione) {
		this.dataFinePrenotazione = dataFinePrenotazione;
	}

	public LocalDate getDataInizioPrenotazione() {
		return dataInizioPrenotazione;
	}

	public void setDataInizioPrenotazione(LocalDate dataInizioPrenotazione) {
		this.dataInizioPrenotazione = dataInizioPrenotazione;
	}

	public Double getTotale() {
		return totale;
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public StatoPrenotazione getStatoPrenotazione() {
		return statoPrenotazione;
	}

	public void setStatoPrenotazione(StatoPrenotazione statoPrenotazione) {
		this.statoPrenotazione = statoPrenotazione;
	}

	public List<Comprende> getListaComprende() {
		return listaComprende;
	}

	public void setListaComprende(List<Comprende> listaComprende) {
		this.listaComprende = listaComprende;
	}
	
	
}
