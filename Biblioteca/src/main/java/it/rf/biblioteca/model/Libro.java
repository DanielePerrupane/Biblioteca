package it.rf.biblioteca.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name="Libro")
public class Libro {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idLibro;
	@Column
	private String autoreLibro;
	@Column
	private Double costoGiornaliero;
	@Column
	private String titoloLibro;
	
	@ManyToOne
	@JoinColumn(name="idGenere")
	private Genere genere;
	
	@OneToMany(mappedBy="idComprende")
	@JsonIgnore
	private List<Comprende> listaComprende;
	
	public Libro() {
		
	}

	public Libro(Integer idLibro, String autoreLibro, Double costoGiornaliero, String titoloLibro, Genere genere,
			List<Comprende> listaComprende) {
		super();
		this.idLibro = idLibro;
		this.autoreLibro = autoreLibro;
		this.costoGiornaliero = costoGiornaliero;
		this.titoloLibro = titoloLibro;
		this.genere = genere;
		this.listaComprende = listaComprende;
	}

	public Integer getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(Integer idLibro) {
		this.idLibro = idLibro;
	}

	public String getAutoreLibro() {
		return autoreLibro;
	}

	public void setAutoreLibro(String autoreLibro) {
		this.autoreLibro = autoreLibro;
	}

	public Double getCostoGiornaliero() {
		return costoGiornaliero;
	}

	public void setCostoGiornaliero(Double costoGiornaliero) {
		this.costoGiornaliero = costoGiornaliero;
	}

	public String getTitoloLibro() {
		return titoloLibro;
	}

	public void setTitoloLibro(String titoloLibro) {
		this.titoloLibro = titoloLibro;
	}

	public Genere getGenere() {
		return genere;
	}

	public void setGenere(Genere genere) {
		this.genere = genere;
	}

	public List<Comprende> getListaComprende() {
		return listaComprende;
	}

	public void setListaComprende(List<Comprende> listaComprende) {
		this.listaComprende = listaComprende;
	}
	
	
	
}
