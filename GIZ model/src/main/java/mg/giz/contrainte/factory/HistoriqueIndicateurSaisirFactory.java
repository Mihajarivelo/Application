package mg.giz.contrainte.factory;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.giz.data.dto.HistoriqueIndicateurSaisirDto;

public class HistoriqueIndicateurSaisirFactory {

	static ObjectMapper mapper = new ObjectMapper();

	public static HistoriqueIndicateurSaisirDto getInstance(String str) {
		HistoriqueIndicateurSaisirDto ind = new HistoriqueIndicateurSaisirDto();
		try {
			
			// System.out.println(str);
			
			Object[] array = mapper.readValue("[" + str + "]", Object[].class);

			ind.setIndicateurId((String) array[0]);
			ind.setIndicateurNom((String) array[1]);
			ind.setIndicateurSrcdonnees((String) array[2]);
			ind.setIndicateurEnnonceobjectif((String) array[3]);

			if (array[4] != null && !array[4].equals("null") && !array[4].equals("")) {
				// System.out.println("valeur = " + array[4]);
				try {
					Double indicateur = Double.valueOf("" + array[4]);
					ind.setIndicateurObjectif(indicateur);
					ind.setIndicateurObjectifLong(indicateur.longValue());
				} catch (ClassCastException e) {
					e.printStackTrace();
				}
			}

			ind.setIndicateurObservation((String) array[5]);
			ind.setIndicateurSituationref((String) array[6]);

			ind.setRapportperiodiqueType((String) array[7]);
			ind.setRapportperiodiqueTypelib((String) array[8]);

			if (array[9] != null) {
				ind.setSituationQ1(Double.parseDouble("" + array[9]));
				ind.setSituationQ1Long(Double.valueOf("" + array[9]).longValue());
			}
			ind.setCommQ1((String) array[10]);

			if (array[11] != null) {
				ind.setSituationQ2(Double.parseDouble("" + array[11]));
				ind.setSituationQ2Long(Double.valueOf("" + array[11]).longValue());
			}
			ind.setCommQ2((String) array[12]);

			if (array[13] != null) {
				ind.setSituationQ3(Double.parseDouble("" + array[13]));
				ind.setSituationQ3Long(Double.valueOf("" + array[13]).longValue());
			}
			ind.setCommQ3((String) array[14]);

			if (array[15] != null) {
				ind.setSituationQ4(Double.parseDouble("" + array[15]));
				ind.setSituationQ4Long(Double.valueOf("" + array[15]).longValue());
			}
			ind.setCommQ4((String) array[16]);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ind;
	}

	public static List<HistoriqueIndicateurSaisirDto> getInstances(List<String> strs) {
		List<HistoriqueIndicateurSaisirDto> result = new ArrayList<>();
		for (String str : strs) {
			result.add(getInstance(str));
		}
		return result;
	}

}
