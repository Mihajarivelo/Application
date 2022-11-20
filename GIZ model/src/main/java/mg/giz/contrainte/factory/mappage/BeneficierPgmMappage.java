package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class BeneficierPgmMappage {
	public static Map<String, Integer> tableBeneficierPgmMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> beneficierPgmMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();
			if (NameExcelColumn != null) {
				switch (NameExcelColumn) {
				case "beneficierpgm_date":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("beneficierpgm_date", index);
					break;
				case "beneficierpgm_effectif":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("beneficierpgm_effectif", index);
					break;
				case "beneficierpgm_groupemod":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("beneficierpgm_groupemod", index);
					break;
				case "beneficierpgm_lieu":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("beneficierpgm_lieu", index);
					break;
				case "beneficierpgm_plandeviedeux":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("beneficierpgm_plandeviedeux", index);
					break;
				case "beneficierpgm_plandevieun":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("beneficierpgm_plandevieun", index);
					break;
				case "beneficierpgm_speculation":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("beneficierpgm_speculation", index);
					break;
				case "beneficierpgm_valeur":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("beneficierpgm_valeur", index);
					break;
				case "inscrismfr_anneesco":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("inscrismfr_anneesco", index);
					break;
				case "inscrismfr_niveau":
					index = columnStructure.get(i).getIndex();
					beneficierPgmMapping.put("inscrismfr_niveau", index);
					break;
				}
			}
		}
		return beneficierPgmMapping;
	}

}
