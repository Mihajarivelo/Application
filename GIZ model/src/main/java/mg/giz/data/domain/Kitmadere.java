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
@Table(name = "kitmadere")
public class Kitmadere {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private Date kitmadere_date;

	private String kitmadere_observation;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enseignantepp_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Enseignantepp enseignantepp;

	@Column(insertable = false, updatable = false)
	private Long enseignantepp_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getKitmadere_date() {
		return kitmadere_date;
	}

	public void setKitmadere_date(Date kitmadere_date) {
		this.kitmadere_date = kitmadere_date;
	}

	public String getKitmadere_observation() {
		return kitmadere_observation;
	}

	public void setKitmadere_observation(String kitmadere_observation) {
		this.kitmadere_observation = kitmadere_observation;
	}

	public Enseignantepp getEnseignantepp() {
		return enseignantepp;
	}

	public void setEnseignantepp(Enseignantepp enseignantepp) {
		this.enseignantepp = enseignantepp;
	}

	public Long getEnseignantepp_id() {
		return enseignantepp_id;
	}

	public void setEnseignantepp_id(Long enseignantepp_id) {
		this.enseignantepp_id = enseignantepp_id;
	}

	@Override
	public String toString() {
		return "Kitmadere [id=" + id + ", kitmadere_date=" + kitmadere_date + ", kitmadere_observation="
				+ kitmadere_observation + ", enseignantepp=" + enseignantepp + ", enseignantepp_id=" + enseignantepp_id
				+ "]";
	}
}
