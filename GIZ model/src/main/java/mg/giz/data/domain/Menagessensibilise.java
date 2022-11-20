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
@Table(name = "menagessensibilise")
public class Menagessensibilise {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String menagessensibilise_lib;

	@Column(nullable = false)
	private Date menagessensibilise_date;

	private Integer menagessensibilise_homme;
	private Integer menagessensibilise_femme;
	private Integer menagessensibilise_garcon;
	private Integer menagessensibilise_fille;

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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMenagessensibilise_lib() {
		return menagessensibilise_lib;
	}

	public void setMenagessensibilise_lib(String menagessensibilise_lib) {
		this.menagessensibilise_lib = menagessensibilise_lib;
	}

	public Date getMenagessensibilise_date() {
		return menagessensibilise_date;
	}

	public void setMenagessensibilise_date(Date menagessensibilise_date) {
		this.menagessensibilise_date = menagessensibilise_date;
	}

	public Integer getMenagessensibilise_homme() {
		return menagessensibilise_homme;
	}

	public void setMenagessensibilise_homme(Integer menagessensibilise_homme) {
		this.menagessensibilise_homme = menagessensibilise_homme;
	}

	public Integer getMenagessensibilise_femme() {
		return menagessensibilise_femme;
	}

	public void setMenagessensibilise_femme(Integer menagessensibilise_femme) {
		this.menagessensibilise_femme = menagessensibilise_femme;
	}

	public Integer getMenagessensibilise_garcon() {
		return menagessensibilise_garcon;
	}

	public void setMenagessensibilise_garcon(Integer menagessensibilise_garcon) {
		this.menagessensibilise_garcon = menagessensibilise_garcon;
	}

	public Integer getMenagessensibilise_fille() {
		return menagessensibilise_fille;
	}

	public void setMenagessensibilise_fille(Integer menagessensibilise_fille) {
		this.menagessensibilise_fille = menagessensibilise_fille;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
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

	@Override
	public String toString() {
		return "Menagessensibilise [id=" + id + ", menagessensibilise_lib=" + menagessensibilise_lib
				+ ", menagessensibilise_date=" + menagessensibilise_date + ", menagessensibilise_homme="
				+ menagessensibilise_homme + ", menagessensibilise_femme=" + menagessensibilise_femme
				+ ", menagessensibilise_garcon=" + menagessensibilise_garcon + ", menagessensibilise_fille="
				+ menagessensibilise_fille + ", theme=" + theme + ", village=" + village + ", theme_id=" + theme_id
				+ ", code_fkt=" + code_fkt + "]";
	}

}
