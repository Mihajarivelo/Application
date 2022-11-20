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
@Table(name = "concerner")
public class Concerner {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "theme_id", nullable = true)
	@Fetch(FetchMode.JOIN)
	private Theme theme;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ecoleepp_id", nullable = false)
	@Fetch(FetchMode.JOIN)
	private Ecoleepp ecoleepp;

	@Column(nullable = false)
	private Date concerner_date;
	@Column(length = 50)
	private String concerner_typeecole;

	@Column(insertable = false, updatable = false)
	private Long theme_id;
	@Column(insertable = false, updatable = false)
	private Long ecoleepp_id;

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

	public Ecoleepp getEcoleepp() {
		return ecoleepp;
	}

	public void setEcoleepp(Ecoleepp ecoleepp) {
		this.ecoleepp = ecoleepp;
	}

	public Date getConcerner_date() {
		return concerner_date;
	}

	public void setConcerner_date(Date concerner_date) {
		this.concerner_date = concerner_date;
	}

	public String getConcerner_typeecole() {
		return concerner_typeecole;
	}

	public void setConcerner_typeecole(String concerner_typeecole) {
		this.concerner_typeecole = concerner_typeecole;
	}

	public Long getTheme_id() {
		return theme_id;
	}

	public void setTheme_id(Long theme_id) {
		this.theme_id = theme_id;
	}

	public Long getEcoleepp_id() {
		return ecoleepp_id;
	}

	public void setEcoleepp_id(Long ecoleepp_id) {
		this.ecoleepp_id = ecoleepp_id;
	}

	@Override
	public String toString() {
		return "Concerner [id=" + id + ", theme=" + theme + ", ecoleepp=" + ecoleepp + ", concerner_date="
				+ concerner_date + ", concerner_typeecole=" + concerner_typeecole + ", theme_id=" + theme_id
				+ ", ecoleepp_id=" + ecoleepp_id + "]";
	}
}
