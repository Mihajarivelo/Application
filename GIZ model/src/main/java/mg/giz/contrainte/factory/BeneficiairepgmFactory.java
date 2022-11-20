package mg.giz.contrainte.factory;

import java.util.ArrayList;
import java.util.List;

import mg.giz.data.dto.BeneficiaireDto;

public class BeneficiairepgmFactory {

	public static BeneficiaireDto getInstance(String str) {
		BeneficiaireDto benef = new BeneficiaireDto();
		String[] parts = str.split(",");
		benef.setNbrBeneficiant(Long.parseLong(parts[0]));
		benef.setPersonneGenre(parts[1]);
		benef.setThemeLib(parts[2]);
		benef.setBeneficierPrgmDate(parts[3]);
		benef.setVillageNom(parts[4]);
		benef.setCommune(parts[5]);
		benef.setDistrict(parts[6]);
		return benef;
	}
	
	public static List<BeneficiaireDto> getInstances(List<String> strs) {
		List<BeneficiaireDto> result = new ArrayList<>();
		for(String str:strs) {
			result.add(getInstance(str));
		}
		return result;
	}
}
