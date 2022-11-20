package mg.giz.contrainte.factory;

import java.util.ArrayList;
import java.util.List;
import mg.giz.data.dto.IndicateurDto;

public class IndicateursFactory {

	public static IndicateurDto getInstance(String str) {
		IndicateurDto ind = new IndicateurDto();
		String[] parts = str.split(",");
		
		ind.setIndicateurCode(parts[0]);
		ind.setIndicateurNom(parts[1]);
		ind.setIndicateurSrcdonnees(parts[2]);
		ind.setIndicateurObjectif(Double.parseDouble(parts[3]));
		ind.setIndicateurObservation(parts[4]);
		ind.setIndicateurSituationref(parts[5]);
		ind.setNbreBeneficiaires(Long.parseLong(parts[6]));
		ind.setPourcentageRealisation(parts[7]);
		return ind;
	}

	public static List<IndicateurDto> getInstances(List<String> strs) {
		List<IndicateurDto> result = new ArrayList<>();
		for (String str : strs) {
			result.add(getInstance(str));
		}
		return result;
	}
}
