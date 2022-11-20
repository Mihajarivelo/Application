package mg.giz.contrainte.factory;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.giz.data.dto.BeneficiaireVillageDto;

public class BeneficiaireVillageFactory {

	static ObjectMapper mapper = new ObjectMapper();

	public static BeneficiaireVillageDto getInstance(String str) {
		BeneficiaireVillageDto ind = new BeneficiaireVillageDto();
		try {

			// System.out.println(str);
			Object[] array = mapper.readValue("[" + str + "]", Object[].class);

			if (array[0] != null && !array[0].equals("null") && !array[0].equals(" ")) {
				ind.setPersonneNom((String) array[0]);
			}
			if (array[1] != null && !array[1].equals("null") && !array[1].equals(" ")) {
				ind.setPersonneGenre((String) array[1]);
			}
			if (array[2] != null && !array[2].equals("null") && !array[2].equals(" ")) {
				ind.setDistrict((String) array[2]);
			}
			if (array[3] != null && !array[3].equals("null") && !array[3].equals(" ")) {
				ind.setCommune((String) array[3]);
			}
			if (array[4] != null && !array[4].equals("null") && !array[4].equals(" ")) {
				ind.setCodeFkt((String) array[4]);
			}
			if (array[5] != null && !array[5].equals("null") && !array[5].equals(" ")) {
				ind.setVillageNom((String) array[5]);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ind;
	}

	public static List<BeneficiaireVillageDto> getInstances(List<String> strs) {
		List<BeneficiaireVillageDto> result = new ArrayList<>();
		for (String str : strs) {
			result.add(getInstance(str));
		}
		return result;
	}
}
