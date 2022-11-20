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
@Table(name = "visiteurferme")
public class Visiteurferme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date visiteurferme_date;

	private String visiteurferme_nom;
	private Long visiteurferme_valeur;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_fkt", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Village village;

	@Column(length = 32, insertable = false, updatable = false)
	private String code_fkt;

	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getVisiteurferme_date() {
		return visiteurferme_date;
	}

	public void setVisiteurferme_date(Date visiteurferme_date) {
		this.visiteurferme_date = visiteurferme_date;
	}

	public String getVisiteurferme_nom() {
		return visiteurferme_nom;
	}

	public void setVisiteurferme_nom(String visiteurferme_nom) {
		this.visiteurferme_nom = visiteurferme_nom;
	}

	public Long getVisiteurferme_valeur() {
		return visiteurferme_valeur;
	}

	public void setVisiteurferme_valeur(Long visiteurferme_valeur) {
		this.visiteurferme_valeur = visiteurferme_valeur;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public String getCode_fkt() {
		return code_fkt;
	}

	public void setCode_fkt(String code_fkt) {
		this.code_fkt = code_fkt;
	}

	public Souscomposante getSouscomposante() {
		return souscomposante;
	}

	public void setSouscomposante(Souscomposante souscomposante) {
		this.souscomposante = souscomposante;
	}

	public String getSouscomposante_code() {
		return souscomposante_code;
	}

	public void setSouscomposante_code(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	@Override
	public String toString() {
		return "Visiteurferme [id=" + id + ", visiteurferme_date=" + visiteurferme_date + ", visiteurferme_nom="
				+ visiteurferme_nom + ", visiteurferme_valeur=" + visiteurferme_valeur + ", village=" + village
				+ ", code_fkt=" + code_fkt + "]";
	}
}
