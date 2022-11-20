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
@Table(name = "subvenirepp")
public class Subvenirepp {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "subventionepp_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Subventionepp subventionepp;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ecoleepp_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Ecoleepp ecoleepp;

	@Column(nullable = false)
	private Date subvenirepp_date;
	@Column(length = 50)
	private String subvenirepp_ansco;

	private Double subvenirepp_rehabilitaion;
	private Double subvenirepp_salaire;
	private Double subvenirepp_fourniture;

	@Column(insertable = false, updatable = false)
	private Integer subventionepp_id;
	@Column(insertable = false, updatable = false)
	private Long ecoleepp_id;

	public Integer getSubventionepp_id() {
		return subventionepp_id;
	}

	public void setSubventionepp_id(Integer subventionepp_id) {
		this.subventionepp_id = subventionepp_id;
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

	public Subventionepp getSubventionepp() {
		return subventionepp;
	}

	public void setSubventionepp(Subventionepp subventionepp) {
		this.subventionepp = subventionepp;
	}

	public Ecoleepp getEcoleepp() {
		return ecoleepp;
	}

	public void setEcoleepp(Ecoleepp ecoleepp) {
		this.ecoleepp = ecoleepp;
	}

	public Date getSubvenirepp_date() {
		return subvenirepp_date;
	}

	public void setSubvenirepp_date(Date subvenirepp_date) {
		this.subvenirepp_date = subvenirepp_date;
	}

	public String getSubvenirepp_ansco() {
		return subvenirepp_ansco;
	}

	public void setSubvenirepp_ansco(String subvenirepp_ansco) {
		this.subvenirepp_ansco = subvenirepp_ansco;
	}

	public Double getSubvenirepp_rehabilitaion() {
		return subvenirepp_rehabilitaion;
	}

	public void setSubvenirepp_rehabilitaion(Double subvenirepp_rehabilitaion) {
		this.subvenirepp_rehabilitaion = subvenirepp_rehabilitaion;
	}

	public Double getSubvenirepp_salaire() {
		return subvenirepp_salaire;
	}

	public void setSubvenirepp_salaire(Double subvenirepp_salaire) {
		this.subvenirepp_salaire = subvenirepp_salaire;
	}

	public Double getSubvenirepp_fourniture() {
		return subvenirepp_fourniture;
	}

	public void setSubvenirepp_fourniture(Double subvenirepp_fourniture) {
		this.subvenirepp_fourniture = subvenirepp_fourniture;
	}

	@Override
	public String toString() {
		return "Subvenirepp [id=" + id + ", subventionepp=" + subventionepp + ", ecoleepp=" + ecoleepp
				+ ", subvenirepp_date=" + subvenirepp_date + ", subvenirepp_ansco=" + subvenirepp_ansco
				+ ", subvenirepp_rehabilitaion=" + subvenirepp_rehabilitaion + ", subvenirepp_salaire="
				+ subvenirepp_salaire + ", subvenirepp_fourniture=" + subvenirepp_fourniture + ", subventionepp_id="
				+ subventionepp_id + ", ecoleepp_id=" + ecoleepp_id + "]";
	}

}
