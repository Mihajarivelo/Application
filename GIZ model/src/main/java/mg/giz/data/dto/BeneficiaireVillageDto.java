package mg.giz.data.dto;

public class BeneficiaireVillageDto {

	private String personneNom;
	private String personneGenre;
	private String district;
	private String commune;
	private String codeFkt;
	private String villageNom;

	public String getPersonneNom() {
		return personneNom;
	}

	public void setPersonneNom(String personneNom) {
		this.personneNom = personneNom;
	}

	public String getPersonneGenre() {
		return personneGenre;
	}

	public void setPersonneGenre(String personneGenre) {
		this.personneGenre = personneGenre;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getCodeFkt() {
		return codeFkt;
	}

	public void setCodeFkt(String codeFkt) {
		this.codeFkt = codeFkt;
	}

	public String getVillageNom() {
		return villageNom;
	}

	public void setVillageNom(String villageNom) {
		this.villageNom = villageNom;
	}
}
