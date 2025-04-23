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
@Table(name="CategoriaOperatore")
public class CategoriaOperatore {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCategoriaOperatore;
	@Column
	private String nomeCategoriaOperatore;
	
	 
	@OneToMany(mappedBy="cfOperatore")
	private List<Operatore> listaOperatori;
	
	public CategoriaOperatore() {
		
	}

	public CategoriaOperatore(Integer idCategoriaOperatore, String nomeCategoriaOperatore,
			List<Operatore> listaOperatori) {
		super();
		this.idCategoriaOperatore = idCategoriaOperatore;
		this.nomeCategoriaOperatore = nomeCategoriaOperatore;
		this.listaOperatori = listaOperatori;
	}

	public Integer getIdCategoriaOperatore() {
		return idCategoriaOperatore;
	}

	public void setIdCategoriaOperatore(Integer idCategoriaOperatore) {
		this.idCategoriaOperatore = idCategoriaOperatore;
	}

	public String getNomeCategoriaOperatore() {
		return nomeCategoriaOperatore;
	}

	public void setNomeCategoriaOperatore(String nomeCategoriaOperatore) {
		this.nomeCategoriaOperatore = nomeCategoriaOperatore;
	}

	public List<Operatore> getListaOperatori() {
		return listaOperatori;
	}

	public void setListaOperatori(List<Operatore> listaOperatori) {
		this.listaOperatori = listaOperatori;
	}
	
	
	
}
