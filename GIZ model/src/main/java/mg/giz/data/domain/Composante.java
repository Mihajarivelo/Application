package mg.giz.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "composante")
public class Composante {

	@Id
	@Column(length = 5)
	private String composante_code;

	@NotBlank
	@Column(columnDefinition = "TEXT")
	private String composante_nom;

	public String getComposante_code() {
		return composante_code;
	}

	public void setComposante_code(String composante_code) {
		this.composante_code = composante_code;
	}

	public String getComposante_nom() {
		return composante_nom;
	}

	public void setComposante_nom(String composante_nom) {
		this.composante_nom = composante_nom;
	}

	@Override
	public String toString() {
		return "Composante [composante_code=" + composante_code + ", composante_nom=" + composante_nom + "]";
	}
}
