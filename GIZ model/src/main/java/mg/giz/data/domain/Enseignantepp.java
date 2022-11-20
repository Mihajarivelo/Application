package mg.giz.data.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "enseignantepp")
public class Enseignantepp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = true)

	private Date enseignantepp_date;

	private String enseignantepp_nom;
	@Column(length = 10)
	private String enseignantepp_genre;
	@Column(length = 100)
	private String enseignantepp_fonction;
	@Column(length = 50)
	private String enseignantepp_classe;
	@Column(length = 100)
	private String enseignantepp_contact;
	private String enseignantepp_adresse;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ecoleepp_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Ecoleepp ecoleepp;

	@Column(insertable = false, updatable = false)
	private Long ecoleepp_id;

	public Enseignantepp(Long id) {
		this.id = id;
	}

	public Enseignantepp() {
		// TODO Auto-generated constructor stub
	}

	public Long getEcoleepp_id() {
		return ecoleepp_id;
	}

	public void setEcoleepp_id(Long ecoleepp_id) {
		this.ecoleepp_id = ecoleepp_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getEnseignantepp_date() {
		return enseignantepp_date;
	}

	public void setEnseignantepp_date(Date enseignantepp_date) {
		this.enseignantepp_date = enseignantepp_date;
	}

	public String getEnseignantepp_nom() {
		return enseignantepp_nom;
	}

	public void setEnseignantepp_nom(String enseignantepp_nom) {
		this.enseignantepp_nom = enseignantepp_nom;
	}

	public String getEnseignantepp_genre() {
		return enseignantepp_genre;
	}

	public void setEnseignantepp_genre(String enseignantepp_genre) {
		this.enseignantepp_genre = enseignantepp_genre;
	}

	public String getEnseignantepp_fonction() {
		return enseignantepp_fonction;
	}

	public void setEnseignantepp_fonction(String enseignantepp_fonction) {
		this.enseignantepp_fonction = enseignantepp_fonction;
	}

	public String getEnseignantepp_classe() {
		return enseignantepp_classe;
	}

	public void setEnseignantepp_classe(String enseignantepp_classe) {
		this.enseignantepp_classe = enseignantepp_classe;
	}

	public String getEnseignantepp_contact() {
		return enseignantepp_contact;
	}

	public void setEnseignantepp_contact(String enseignantepp_contact) {
		this.enseignantepp_contact = enseignantepp_contact;
	}

	public String getEnseignantepp_adresse() {
		return enseignantepp_adresse;
	}

	public void setEnseignantepp_adresse(String enseignantepp_adresse) {
		this.enseignantepp_adresse = enseignantepp_adresse;
	}

	public Ecoleepp getEcoleepp() {
		return ecoleepp;
	}

	public void setEcoleepp(Ecoleepp ecoleepp) {
		this.ecoleepp = ecoleepp;
	}

	@Override
	public String toString() {
		return "Enseignantepp [id=" + id + ", enseignantepp_date=" + enseignantepp_date + ", enseignantepp_nom="
				+ enseignantepp_nom + ", enseignantepp_genre=" + enseignantepp_genre + ", enseignantepp_fonction="
				+ enseignantepp_fonction + ", enseignantepp_classe=" + enseignantepp_classe + ", enseignantepp_contact="
				+ enseignantepp_contact + ", enseignantepp_adresse=" + enseignantepp_adresse + ", ecoleepp=" + ecoleepp
				+ ", ecoleepp_id=" + ecoleepp_id + "]";
	}
}
