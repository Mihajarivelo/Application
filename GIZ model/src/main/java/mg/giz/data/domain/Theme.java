package mg.giz.data.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "theme")
public class Theme {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long theme_id;

	private String theme_lib;
	@Column(length = 100)
	private String theme_vslahameau;
	@Column(nullable = true)
	private Date theme_date;
	@Column(length = 100)
	private String theme_programme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_fkt", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Village village;

	@OneToMany(targetEntity = Beneficierpgm.class, mappedBy = "theme", orphanRemoval = false, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Beneficierpgm> beneficierpgms = new HashSet<>();

	@OneToMany(targetEntity = Ameliorer.class, mappedBy = "theme", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Ameliorer> ameliorers;

	@OneToMany(targetEntity = Concerner.class, mappedBy = "theme", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Concerner> concerners;

	@OneToMany(targetEntity = Avoircycle.class, mappedBy = "theme", cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.LAZY)
	private Set<Avoircycle> Avoircycles;

	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;

	@Column(length = 32, insertable = false, updatable = false)
	private String code_fkt;

	public Theme(Long theme_id) {
		this.theme_id = theme_id;
	}

	public Theme() {
		// TODO Auto-generated constructor stub
	}

	public String getSouscomposante_code() {
		return souscomposante_code;
	}

	public void setSouscomposante_code(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	public String getCode_fkt() {
		return code_fkt;
	}

	public void setCode_fkt(String code_fkt) {
		this.code_fkt = code_fkt;
	}

	public Long getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(Long theme_id) {
		this.theme_id = theme_id;
	}

	public String getTheme_lib() {
		return theme_lib;
	}

	public void setTheme_lib(String theme_lib) {
		this.theme_lib = theme_lib;
	}

	public String getTheme_vslahameau() {
		return theme_vslahameau;
	}

	public void setTheme_vslahameau(String theme_vslahameau) {
		this.theme_vslahameau = theme_vslahameau;
	}

	public Date getTheme_date() {
		return theme_date;
	}

	public void setTheme_date(Date theme_date) {
		this.theme_date = theme_date;
	}

	public String getTheme_programme() {
		return theme_programme;
	}

	public void setTheme_programme(String theme_programme) {
		this.theme_programme = theme_programme;
	}

	public Souscomposante getSouscomposante() {
		return souscomposante;
	}

	public void setSouscomposante(Souscomposante souscomposante) {
		this.souscomposante = souscomposante;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public Set<Beneficierpgm> getBeneficierpgms() {
		return beneficierpgms;
	}

	public void setBeneficierpgms(Set<Beneficierpgm> beneficierpgms) {
		this.beneficierpgms = beneficierpgms;
	}

	public Set<Ameliorer> getAmeliorers() {
		return ameliorers;
	}

	public void setAmeliorers(Set<Ameliorer> ameliorers) {
		this.ameliorers = ameliorers;
	}

	public Set<Concerner> getConcerners() {
		return concerners;
	}

	public void setConcerners(Set<Concerner> concerners) {
		this.concerners = concerners;
	}

	public Set<Avoircycle> getAvoircycles() {
		return Avoircycles;
	}

	public void setAvoircycles(Set<Avoircycle> avoircycles) {
		Avoircycles = avoircycles;
	}

	/*@Override
	public String toString() {
		return "Theme [theme_id=" + theme_id + ", theme_lib=" + theme_lib + ", theme_vslahameau=" + theme_vslahameau
				+ ", theme_date=" + theme_date + ", theme_programme=" + theme_programme + ", village=" + village + ", code_fkt=" + code_fkt + "]";
	}*/
}
