package mg.giz.data.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "accueil")
public class Accueil implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7006811701804701616L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Column(columnDefinition = "TEXT", nullable = true)
	private String accueil_text1;

	@Column(columnDefinition = "TEXT", nullable = true)
	private String accueil_text2;

	public Accueil() {
		super();
	}

	public Accueil(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccueil_text1() {
		return accueil_text1;
	}

	public void setAccueil_text1(String accueil_text1) {
		this.accueil_text1 = accueil_text1;
	}

	public String getAccueil_text2() {
		return accueil_text2;
	}

	public void setAccueil_text2(String accueil_text2) {
		this.accueil_text2 = accueil_text2;
	}

	@Override
	public String toString() {
		return "Accueil [id=" + id + ", accueil_text1=" + accueil_text1 + ", accueil_text2=" + accueil_text2 + "]";
	}
}
