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
@Table(name = "glossaire")
public class Glossaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5652700307373531553L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "id")
	private Long id;

	@NotBlank
	private String glossaire_theme;

	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String glossaire_desc;

	public Glossaire() {
		super();
	}

	public Glossaire(Long id) {
		super();
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGlossaire_theme() {
		return glossaire_theme;
	}

	public void setGlossaire_theme(String glossaire_theme) {
		this.glossaire_theme = glossaire_theme;
	}

	public String getGlossaire_desc() {
		return glossaire_desc;
	}

	public void setGlossaire_desc(String glossaire_desc) {
		this.glossaire_desc = glossaire_desc;
	}

	@Override
	public String toString() {
		return "Glossaire [id=" + id + ", glossaire_theme=" + glossaire_theme + ", glossaire_desc=" + glossaire_desc
				+ "]";
	}
}
