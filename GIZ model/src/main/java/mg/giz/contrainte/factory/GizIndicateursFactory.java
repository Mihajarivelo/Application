package mg.giz.contrainte.factory;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.giz.data.dto.GizIndicateurDto;

public class GizIndicateursFactory {

	static ObjectMapper mapper = new ObjectMapper();

	public static GizIndicateurDto getInstance(String str) {
		GizIndicateurDto ind = new GizIndicateurDto();
		try {
			// System.out.println(str);
			Object[] array = mapper.readValue("[" + str + "]", Object[].class);
			ind.setIndicateurId((String) array[0]);
			ind.setIndicateurNom((String) array[1]);
			ind.setIndicateurSrcdonnees((String) array[2]);
			ind.setIndicateurEnnonceobjectif((String) array[3]);
			if (array[4] != null && !array[4].equals("null") && !array[4].equals("")) {
				System.out.println("valeur = " + array[4]);
				try {
					ind.setIndicateurObjectif(((Integer) array[4]).doubleValue());
					ind.setIndicateurObjectifLong(((Integer) array[4]).longValue());
				} catch (ClassCastException e) {

				}
			}
			ind.setPourcentageRealisation((String) array[5]);
			ind.setIndicateurObservation((String) array[6]);
			ind.setIndicateurSituationref((String) array[7]);
			ind.setNbreBeneficiaires(((Integer) array[8]).longValue());

			if (array[9] != null) {
				ind.setSituationQ1(((Integer) array[9]).toString());
			}
			ind.setCommQ1((String) array[10]);

			if (array[11] != null) {
				ind.setSituationQ2(((Integer) array[11]).toString());
			}
			ind.setCommQ2((String) array[12]);

			if (array[13] != null) {
				ind.setSituationQ3(((Integer) array[13]).toString());
			}
			ind.setCommQ3((String) array[14]);

			if (array[15] != null) {
				ind.setSituationQ4(((Integer) array[15]).toString());
			}
			ind.setCommQ4((String) array[16]);

		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		 * String[] parts = str.split(",");
		 * 
		 * ind.setIndicateurId(parts[0]); ind.setIndicateurNom(parts[1]);
		 * ind.setIndicateurSrcdonnees(parts[2]);
		 * ind.setIndicateurEnnonceobjectif(parts[3]);
		 * ind.setIndicateurObjectif(Double.parseDouble(parts[4]));
		 * ind.setPourcentageRealisation(parts[5]);
		 * ind.setIndicateurObservation(parts[6]);
		 * ind.setIndicateurSituationref(parts[7]);
		 * ind.setNbreBeneficiaires(Long.parseLong(parts[8]));
		 * 
		 * ind.setSituationQ1(parts[9]); ind.setCommQ1(parts[10]);
		 * ind.setSituationQ2(parts[11]); ind.setCommQ2(parts[12]);
		 * ind.setSituationQ3(parts[13]); ind.setCommQ3(parts[14]);
		 * ind.setSituationQ4(parts[15]); ind.setCommQ4(parts[16]);
		 */

		return ind;
	}

	public static List<GizIndicateurDto> getInstances(List<String> strs) {
		List<GizIndicateurDto> result = new ArrayList<>();
		for (String str : strs) {
			result.add(getInstance(str));
		}
		return result;
	}
}
