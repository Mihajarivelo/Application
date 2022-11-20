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
@Table(name = "nombreeleve")
public class Nombreeleve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false)
	private Date nombreeleve_date;

	private Long nombreeleve_valeur;
	private Long nombreeleve_garcon;
	private Long nombreeleve_fille;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ecoleepp_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Ecoleepp ecoleepp;

	@Column(insertable = false, updatable = false)
	private Long ecoleepp_id;

	public Long getEcoleepp_id() {
		return ecoleepp_id;
	}

	public void setEcoleepp_id(Long ecoleepp_id) {
		this.ecoleepp_id = ecoleepp_id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getNombreeleve_date() {
		return nombreeleve_date;
	}

	public void setNombreeleve_date(Date nombreeleve_date) {
		this.nombreeleve_date = nombreeleve_date;
	}

	public Long getNombreeleve_valeur() {
		return nombreeleve_valeur;
	}

	public void setNombreeleve_valeur(Long nombreeleve_valeur) {
		this.nombreeleve_valeur = nombreeleve_valeur;
	}

	public Long getNombreeleve_garcon() {
		return nombreeleve_garcon;
	}

	public void setNombreeleve_garcon(Long nombreeleve_garcon) {
		this.nombreeleve_garcon = nombreeleve_garcon;
	}

	public Long getNombreeleve_fille() {
		return nombreeleve_fille;
	}

	public void setNombreeleve_fille(Long nombreeleve_fille) {
		this.nombreeleve_fille = nombreeleve_fille;
	}

	public Ecoleepp getEcoleepp() {
		return ecoleepp;
	}

	public void setEcoleepp(Ecoleepp ecoleepp) {
		this.ecoleepp = ecoleepp;
	}

	@Override
	public String toString() {
		return "Nombreeleve [id=" + id + ", nombreeleve_date=" + nombreeleve_date + ", nombreeleve_valeur="
				+ nombreeleve_valeur + ", nombreeleve_garcon=" + nombreeleve_garcon + ", nombreeleve_fille="
				+ nombreeleve_fille + ", ecoleepp=" + ecoleepp + ", ecoleepp_id=" + ecoleepp_id + "]";
	}
}
