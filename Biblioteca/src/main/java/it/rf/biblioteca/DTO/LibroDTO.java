package it.rf.biblioteca.DTO;

public class LibroDTO {
	
	private String autoreLibro;
	private String titoloLibro;
	private Double costoGiornaliero;
	private String nomeGenere;
	
	public String getAutoreLibro() {
		return autoreLibro;
	}
	public void setAutoreLibro(String autoreLibro) {
		this.autoreLibro = autoreLibro;
	}
	public String getTitoloLibro() {
		return titoloLibro;
	}
	public void setTitoloLibro(String titoloLibro) {
		this.titoloLibro = titoloLibro;
	}
	public Double getCostoGiornaliero() {
		return costoGiornaliero;
	}
	public void setCostoGiornaliero(Double costoGiornaliero) {
		this.costoGiornaliero = costoGiornaliero;
	}
	public String getNomeGenere() {
		return nomeGenere;
	}
	public void setNomeGenere(String nomeGenere) {
		this.nomeGenere = nomeGenere;
	}
	
	public LibroDTO(String autoreLibro, String titoloLibro, Double costoGiornaliero, String nomeGenere) {
		super();
		this.autoreLibro = autoreLibro;
		this.titoloLibro = titoloLibro;
		this.costoGiornaliero = costoGiornaliero;
		this.nomeGenere = nomeGenere;
	}
	
	public LibroDTO() {
		
	}

}
