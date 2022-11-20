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
@Table(name = "mettreoeuvre")
public class Mettreoeuvre {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "groupementprod_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Groupementprod groupementprod;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "serviceprojet_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Serviceprojet serviceprojet;

	@Column(insertable = false, updatable = false)
	private Long groupementprod_id;
	@Column(insertable = false, updatable = false)
	private Long serviceprojet_id;

	@Column(nullable = false)
	private Date mettreoeuvre_date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Groupementprod getGroupementprod() {
		return groupementprod;
	}

	public void setGroupementprod(Groupementprod groupementprod) {
		this.groupementprod = groupementprod;
	}

	public Serviceprojet getServiceprojet() {
		return serviceprojet;
	}

	public void setServiceprojet(Serviceprojet serviceprojet) {
		this.serviceprojet = serviceprojet;
	}

	public Date getMettreoeuvre_date() {
		return mettreoeuvre_date;
	}

	public void setMettreoeuvre_date(Date mettreoeuvre_date) {
		this.mettreoeuvre_date = mettreoeuvre_date;
	}

	public Long getGroupementprod_id() {
		return groupementprod_id;
	}

	public void setGroupementprod_id(Long groupementprod_id) {
		this.groupementprod_id = groupementprod_id;
	}

	public Long getServiceprojet_id() {
		return serviceprojet_id;
	}

	public void setServiceprojet_id(Long serviceprojet_id) {
		this.serviceprojet_id = serviceprojet_id;
	}

	@Override
	public String toString() {
		return "Mettreoeuvre [id=" + id + ", groupementprod=" + groupementprod + ", serviceprojet=" + serviceprojet
				+ ", groupementprod_id=" + groupementprod_id + ", serviceprojet_id=" + serviceprojet_id
				+ ", mettreoeuvre_date=" + mettreoeuvre_date + "]";
	}
}
