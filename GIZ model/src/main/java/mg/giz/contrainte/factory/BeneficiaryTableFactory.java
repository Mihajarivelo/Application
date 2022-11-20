package mg.giz.contrainte.factory;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import mg.giz.data.dto.BeneficiaryTableDto;

public class BeneficiaryTableFactory {

	static ObjectMapper mapper = new ObjectMapper();

	public static BeneficiaryTableDto getInstance(String str) {
		BeneficiaryTableDto ind = new BeneficiaryTableDto();

		try {
			// System.out.println(str);
			Object[] array = mapper.readValue("[" + str + "]", Object[].class);

			Double nbrBenef = Double.parseDouble(array[0] + "");
			ind.setNbreBeneficiaires(nbrBenef);
			ind.setNbreBeneficiairesLong(Long.valueOf(nbrBenef.intValue()));
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return ind;
	}

	public static List<BeneficiaryTableDto> getInstances(List<String> strs) {
		List<BeneficiaryTableDto> result = new ArrayList<>();
		for (String str : strs) {
			result.add(getInstance(str));
		}
		return result;
	}
}
