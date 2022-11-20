package mg.giz.contrainte.factory;

import java.util.ArrayList;
import java.util.List;

import mg.giz.data.dto.RapportDto;

public class RapportFactory {

	public static RapportDto getInstance(String str) {
		RapportDto ind = new RapportDto();
		String[] parts = str.split(",");
		
		ind.setIndicateurCode(parts[0]);
		ind.setIndicateurNom(parts[1]);
		ind.setIndicateurSrcdonnees(parts[2]);

		ind.setIndicateurObjectif(Double.parseDouble(parts[3]));
		ind.setIndicateurObservation(parts[4]);
		ind.setIndicateurSituationref(parts[5]);
		ind.setRapportperiodiqueType(parts[6]);
		ind.setTyperapportLib(parts[7]);
		ind.setRapportperiodiqueValeur(Long.parseLong(parts[8]));
		ind.setRapportperiodiqueSituation(parts[9]);
		ind.setRapportperiodiqueComm(parts[10]);
		ind.setPourcentageRealisation(parts[11]);

		return ind;
	}

	public static List<RapportDto> getInstances(List<String> strs) {
		List<RapportDto> result = new ArrayList<>();
		for (String str : strs) {
			result.add(getInstance(str));
		}
		return result;
	}
	
}
