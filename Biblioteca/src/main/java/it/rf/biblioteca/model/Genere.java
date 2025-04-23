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
@Table(name="Genere")
public class Genere {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idGenere;
	@Column
	private String descrizioneGenere;
	@Column
	private String nomeGenere;
	
	@OneToMany(mappedBy="idLibro")
	private List<Libro> listaLibro;
	
	public Genere() {
		
	}

	public Genere(Integer idGenere, String descrizioneGenere, String nomeGenere, List<Libro> listaLibro) {
		super();
		this.idGenere = idGenere;
		this.descrizioneGenere = descrizioneGenere;
		this.nomeGenere = nomeGenere;
		this.listaLibro = listaLibro;
	}

	public Integer getIdGenere() {
		return idGenere;
	}

	public void setIdGenere(Integer idGenere) {
		this.idGenere = idGenere;
	}

	public String getDescrizioneGenere() {
		return descrizioneGenere;
	}

	public void setDescrizioneGenere(String descrizioneGenere) {
		this.descrizioneGenere = descrizioneGenere;
	}

	public String getNomeGenere() {
		return nomeGenere;
	}

	public void setNomeGenere(String nomeGenere) {
		this.nomeGenere = nomeGenere;
	}

	public List<Libro> getListaLibro() {
		return listaLibro;
	}

	public void setListaLibro(List<Libro> listaLibro) {
		this.listaLibro = listaLibro;
	}
	
	
}
