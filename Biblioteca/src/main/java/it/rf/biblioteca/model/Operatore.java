package it.rf.biblioteca.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Operatore")
public class Operatore {
	
	@Id
	@Column
	private String cfOperatore;
	@Column
	private String cognomeOperatore;
	@Column
	private String nomeOperatore;
	@Column
	private String pswOperatore;
	@Column
	private String usernameOperatore;
	
	@ManyToOne
	@JoinColumn(name="idCategoriaOperatore")
	private CategoriaOperatore categoriaOperatore;
	
	@OneToMany(mappedBy="idGestisce")
	private List<Gestisce> listaGestisce;
	
	public Operatore() {
		
	}

	public Operatore(String cfOperatore, String cognomeOperatore, String nomeOperatore, String pswOperatore,
			String usernameOperatore, CategoriaOperatore categoriaOperatore, List<Gestisce> listaGestisce) {
		super();
		this.cfOperatore = cfOperatore;
		this.cognomeOperatore = cognomeOperatore;
		this.nomeOperatore = nomeOperatore;
		this.pswOperatore = pswOperatore;
		this.usernameOperatore = usernameOperatore;
		this.categoriaOperatore = categoriaOperatore;
		this.listaGestisce = listaGestisce;
	}

	public String getCfOperatore() {
		return cfOperatore;
	}

	public void setCfOperatore(String cfOperatore) {
		this.cfOperatore = cfOperatore;
	}

	public String getCognomeOperatore() {
		return cognomeOperatore;
	}

	public void setCognomeOperatore(String cognomeOperatore) {
		this.cognomeOperatore = cognomeOperatore;
	}

	public String getNomeOperatore() {
		return nomeOperatore;
	}

	public void setNomeOperatore(String nomeOperatore) {
		this.nomeOperatore = nomeOperatore;
	}

	public String getPswOperatore() {
		return pswOperatore;
	}

	public void setPswOperatore(String pswOperatore) {
		this.pswOperatore = pswOperatore;
	}

	public String getUsernameOperatore() {
		return usernameOperatore;
	}

	public void setUsernameOperatore(String usernameOperatore) {
		this.usernameOperatore = usernameOperatore;
	}

	public CategoriaOperatore getCategoriaOperatore() {
		return categoriaOperatore;
	}

	public void setCategoriaOperatore(CategoriaOperatore categoriaOperatore) {
		this.categoriaOperatore = categoriaOperatore;
	}

	public List<Gestisce> getListaGestisce() {
		return listaGestisce;
	}

	public void setListaGestisce(List<Gestisce> listaGestisce) {
		this.listaGestisce = listaGestisce;
	}
	
	
	
	
}
