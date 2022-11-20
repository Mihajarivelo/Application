package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class FomateurMappage {
	public static Map<String, Integer> tableFormateur(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> FormateurMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "formateur_contact":
				index = columnStructure.get(i).getIndex();
				FormateurMapping.put("formateur_contact", index);
				break;
			case "formateur_date":
				index = columnStructure.get(i).getIndex();
				FormateurMapping.put("formateur_date", index);
				break;
			case "formateur_genre":
				index = columnStructure.get(i).getIndex();
				FormateurMapping.put("formateur_genre", index);
				break;
			case "formateur_nom":
				index = columnStructure.get(i).getIndex();
				FormateurMapping.put("formateur_nom", index);
				break;
			case "formateur_observation":
				index = columnStructure.get(i).getIndex();
				FormateurMapping.put("formateur_observation", index);
				break;
			case "code_fkt":
				index = columnStructure.get(i).getIndex();
				FormateurMapping.put("code_fkt", index);
				break;
			case "formateur_adresse":
				index = columnStructure.get(i).getIndex();
				FormateurMapping.put("formateur_adresse", index);
				break;
			case "formateur_fonction":
				index = columnStructure.get(i).getIndex();
				FormateurMapping.put("formateur_fonction", index);
				break;
			}
		}
		return FormateurMapping;
	}

}
