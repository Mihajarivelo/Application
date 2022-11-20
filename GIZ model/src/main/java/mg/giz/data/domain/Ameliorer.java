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
@Table(name = "ameliorer")
public class Ameliorer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Theme theme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "code_fkt", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Village village;

	@Column(nullable = false)
	private Date eaupotable_date;

	private String eaupotable_observation;

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

	public Date getEaupotable_date() {
		return eaupotable_date;
	}

	public void setEaupotable_date(Date eaupotable_date) {
		this.eaupotable_date = eaupotable_date;
	}

	public String getEaupotable_observation() {
		return eaupotable_observation;
	}

	public void setEaupotable_observation(String eaupotable_observation) {
		this.eaupotable_observation = eaupotable_observation;
	}

	@Override
	public String toString() {
		return "Ameliorer [id=" + id + ", theme=" + theme + ", village=" + village + ", eaupotable_date="
				+ eaupotable_date + ", eaupotable_observation=" + eaupotable_observation + ", theme_id=" + theme_id
				+ ", code_fkt=" + code_fkt + "]";
	}

}
