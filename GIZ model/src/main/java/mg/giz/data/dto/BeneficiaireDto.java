package mg.giz.data.dto;

import org.springframework.stereotype.Repository;


public class BeneficiaireDto {

	private Long nbrBeneficiant;
	private String personneGenre;
	private String themeLib;
	private String beneficierPrgmDate;
	private String villageNom;
	private String commune;
	private String district;

	public String getCommune() {
		return commune;
	}

	public void setCommune(String commune) {
		this.commune = commune;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public Long getNbrBeneficiant() {
		return nbrBeneficiant;
	}

	public void setNbrBeneficiant(Long nbrBeneficiant) {
		this.nbrBeneficiant = nbrBeneficiant;
	}

	public String getPersonneGenre() {
		return personneGenre;
	}

	public void setPersonneGenre(String personneGenre) {
		this.personneGenre = personneGenre;
	}

	public String getThemeLib() {
		return themeLib;
	}

	public void setThemeLib(String themeLib) {
		this.themeLib = themeLib;
	}

	public String getBeneficierPrgmDate() {
		return beneficierPrgmDate;
	}

	public void setBeneficierPrgmDate(String beneficierPrgmDate) {
		this.beneficierPrgmDate = beneficierPrgmDate;
	}

	public String getVillageNom() {
		return villageNom;
	}

	public void setVillageNom(String villageNom) {
		this.villageNom = villageNom;
	}
}
