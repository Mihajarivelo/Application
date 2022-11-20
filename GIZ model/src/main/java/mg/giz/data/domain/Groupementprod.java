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
@Table(name = "groupementprod")
public class Groupementprod {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long groupementprod_id;

	private String groupementprod_nom;

	@Column(nullable = false)
	private Date groupementprod_date;

	private String groupementprod_service;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_fkt", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Village village;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "souscomposante_code", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Souscomposante souscomposante;

	@Column(length = 32, insertable = false, updatable = false)
	private String code_fkt;
	@Column(length = 10, insertable = false, updatable = false)
	private String souscomposante_code;

	public Groupementprod(Long groupementprod_id) {
		this.groupementprod_id = groupementprod_id;
	}

	public Groupementprod() {
		// TODO Auto-generated constructor stub
	}

	public String getCode_fkt() {
		return code_fkt;
	}

	public void setCode_fkt(String code_fkt) {
		this.code_fkt = code_fkt;
	}

	public String getSouscomposante_code() {
		return souscomposante_code;
	}

	public void setSouscomposante_code(String souscomposante_code) {
		this.souscomposante_code = souscomposante_code;
	}

	public Long getGroupementprod_id() {
		return groupementprod_id;
	}

	public void setGroupementprod_id(Long groupementprod_id) {
		this.groupementprod_id = groupementprod_id;
	}

	public String getGroupementprod_nom() {
		return groupementprod_nom;
	}

	public void setGroupementprod_nom(String groupementprod_nom) {
		this.groupementprod_nom = groupementprod_nom;
	}

	public Date getGroupementprod_date() {
		return groupementprod_date;
	}

	public void setGroupementprod_date(Date groupementprod_date) {
		this.groupementprod_date = groupementprod_date;
	}

	public String getGroupementprod_service() {
		return groupementprod_service;
	}

	public void setGroupementprod_service(String groupementprod_service) {
		this.groupementprod_service = groupementprod_service;
	}

	public Village getVillage() {
		return village;
	}

	public void setVillage(Village village) {
		this.village = village;
	}

	public Souscomposante getSouscomposante() {
		return souscomposante;
	}

	public void setSouscomposante(Souscomposante souscomposante) {
		this.souscomposante = souscomposante;
	}

	@Override
	public String toString() {
		return "Groupementprod [groupementprod_id=" + groupementprod_id + ", groupementprod_nom=" + groupementprod_nom
				+ ", groupementprod_date=" + groupementprod_date + ", groupementprod_service=" + groupementprod_service
				+ ", village=" + village + ", souscomposante=" + souscomposante + ", code_fkt=" + code_fkt
				+ ", souscomposante_code=" + souscomposante_code + "]";
	}
}
