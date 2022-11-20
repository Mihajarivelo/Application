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
@Table(name = "suivitheme")
public class Suivitheme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date suivitheme_date;

	private Double suivitheme_valeur;
	private Integer suivitheme_homme;
	private Integer suivitheme_femme;
	private String suivitheme_type;
	private String suivitheme_comm;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Theme theme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_fkt", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Village village;

	@Column(insertable = false, updatable = false)
	private Long theme_id;

	@Column(length = 32, insertable = false, updatable = false)
	private String code_fkt;

	public Long getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(Long theme_id) {
		this.theme_id = theme_id;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getSuivitheme_date() {
		return suivitheme_date;
	}

	public void setSuivitheme_date(Date suivitheme_date) {
		this.suivitheme_date = suivitheme_date;
	}

	public Double getSuivitheme_valeur() {
		return suivitheme_valeur;
	}

	public void setSuivitheme_valeur(Double suivitheme_valeur) {
		this.suivitheme_valeur = suivitheme_valeur;
	}

	public Integer getSuivitheme_homme() {
		return suivitheme_homme;
	}

	public void setSuivitheme_homme(Integer suivitheme_homme) {
		this.suivitheme_homme = suivitheme_homme;
	}

	public Integer getSuivitheme_femme() {
		return suivitheme_femme;
	}

	public void setSuivitheme_femme(Integer suivitheme_femme) {
		this.suivitheme_femme = suivitheme_femme;
	}

	public String getSuivitheme_type() {
		return suivitheme_type;
	}

	public void setSuivitheme_type(String suivitheme_type) {
		this.suivitheme_type = suivitheme_type;
	}

	public String getSuivitheme_comm() {
		return suivitheme_comm;
	}

	public void setSuivitheme_comm(String suivitheme_comm) {
		this.suivitheme_comm = suivitheme_comm;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "Suivitheme [id=" + id + ", suivitheme_date=" + suivitheme_date + ", suivitheme_valeur="
				+ suivitheme_valeur + ", suivitheme_homme=" + suivitheme_homme + ", suivitheme_femme="
				+ suivitheme_femme + ", suivitheme_type=" + suivitheme_type + ", suivitheme_comm=" + suivitheme_comm
				+ ", theme=" + theme + ", theme_id=" + theme_id + "]";
	}
}
