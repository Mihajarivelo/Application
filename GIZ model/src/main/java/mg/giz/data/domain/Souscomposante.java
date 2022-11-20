package mg.giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "souscomposante")
public class Souscomposante {

	@Id
	@Column(length = 10)
	private String souscomposante_code;

	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String souscomposante_nom;

	@Column(columnDefinition = "TEXT")
	private String souscomposante_table;

	@Column(columnDefinition = "TEXT")
	private String souscomposante_srcdonnees;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "composante_code", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Composante composante;

	@Column(length = 5, insertable = false, updatable = false)
	private String composante_code;

	/**
	 * 
	 */
	public Souscomposante() {
		super();
	}

	public Souscomposante(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	public String getComposante_code() {
		return composante_code;
	}

	public void setComposante_code(String composante_code) {
		this.composante_code = composante_code;
	}

	public String getSouscomposante_code() {
		return souscomposante_code;
	}

	public void setSouscomposante_code(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	public String getSouscomposante_nom() {
		return souscomposante_nom;
	}

	public void setSouscomposante_nom(String souscomposante_nom) {
		this.souscomposante_nom = souscomposante_nom;
	}

	public Composante getComposante() {
		return composante;
	}

	public void setComposante(Composante composante) {
		this.composante = composante;
	}

	public String getSouscomposante_table() {
		return souscomposante_table;
	}

	public void setSouscomposante_table(String souscomposante_table) {
		this.souscomposante_table = souscomposante_table;
	}

	public String getSouscomposante_srcdonnees() {
		return souscomposante_srcdonnees;
	}

	public void setSouscomposante_srcdonnees(String souscomposante_srcdonnees) {
		this.souscomposante_srcdonnees = souscomposante_srcdonnees;
	}

	@Override
	public String toString() {
		return "Souscomposante [souscomposante_code=" + souscomposante_code + ", souscomposante_nom="
				+ souscomposante_nom + ", souscomposante_table=" + souscomposante_table + ", souscomposante_srcdonnees="
				+ souscomposante_srcdonnees + ", composante=" + composante + ", composante_code=" + composante_code
				+ "]";
	}
}
