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
@Table(name = "avoircycle")
public class Avoircycle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Theme theme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cyclevsla_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Cyclevsla cyclevsla;

	@NotBlank
	@Column(nullable = false)
	private Date avoircycle_date;

	@Column(insertable = false, updatable = false)
	private Long theme_id;
	@Column(insertable = false, updatable = false)
	private Integer cyclevsla_id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	public Cyclevsla getCyclevsla() {
		return cyclevsla;
	}

	public void setCyclevsla(Cyclevsla cyclevsla) {
		this.cyclevsla = cyclevsla;
	}

	public Date getAvoircycle_date() {
		return avoircycle_date;
	}

	public void setAvoircycle_date(Date avoircycle_date) {
		this.avoircycle_date = avoircycle_date;
	}

	public Long getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(Long theme_id) {
		this.theme_id = theme_id;
	}

	public Integer getCyclevsla_id() {
		return cyclevsla_id;
	}

	public void setCyclevsla_id(Integer cyclevsla_id) {
		this.cyclevsla_id = cyclevsla_id;
	}

	@Override
	public String toString() {
		return "Avoircycle [id=" + id + ", theme=" + theme + ", cyclevsla=" + cyclevsla + ", avoircycle_date="
				+ avoircycle_date + ", theme_id=" + theme_id + ", cyclevsla_id=" + cyclevsla_id + "]";
	}
}
