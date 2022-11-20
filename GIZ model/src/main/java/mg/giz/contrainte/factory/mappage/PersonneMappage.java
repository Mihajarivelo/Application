package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class PersonneMappage {
	public static Map<String, Integer> tablePersonne(ArrayList<ColumnStructure> columnStructure) throws ParseException {
		int index = -1;
		Map<String, Integer> PersonneMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();
			if (NameExcelColumn != null) {
				switch (NameExcelColumn) {
				case "code_fkt":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("code_fkt", index);
					break;
				case "personne_adresse":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_adresse", index);
					break;
				case "personne_affiliation":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_affiliation", index);
					break;
				case "personne_anneenaiss":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_anneenaiss", index);
					break;
				case "personne_cin":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_cin", index);
					break;
				case "personne_code":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_code", index);
					break;
				case "personne_contact":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_contact", index);
					break;
				case "personne_genre":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_genre", index);
					break;
				case "personne_lieunaiss":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_lieunaiss", index);
					break;
				case "personne_nom":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("personne_nom", index);
					break;
				case "groupement_id":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("groupement_id", index);
					break;
				case "parentmfr_id":
					index = columnStructure.get(i).getIndex();
					PersonneMapping.put("parentmfr_id", index);
					break;
				}
			}
		}
		return PersonneMapping;
	}

}
