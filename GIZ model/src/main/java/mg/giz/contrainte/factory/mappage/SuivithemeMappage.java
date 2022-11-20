package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class SuivithemeMappage {
	public static Map<String, Integer> tableSuivitheme(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> suivithemeMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "suivitheme_comm":
				index = columnStructure.get(i).getIndex();
				suivithemeMapping.put("suivitheme_comm", index);
				break;
			case "code_fkt":
				index = columnStructure.get(i).getIndex();
				suivithemeMapping.put("code_fkt", index);
				break;
			case "suivitheme_date":
				index = columnStructure.get(i).getIndex();
				suivithemeMapping.put("suivitheme_date", index);
				break;
			case "suivitheme_femme":
				index = columnStructure.get(i).getIndex();
				suivithemeMapping.put("suivitheme_femme", index);
				break;
			case "suivitheme_homme":
				index = columnStructure.get(i).getIndex();
				suivithemeMapping.put("suivitheme_homme", index);
				break;
			case "suivitheme_type":
				index = columnStructure.get(i).getIndex();
				suivithemeMapping.put("suivitheme_type", index);
				break;
			case "suivitheme_valeur":
				index = columnStructure.get(i).getIndex();
				suivithemeMapping.put("suivitheme_valeur", index);
				break;
			}
		}
		return suivithemeMapping;
	}
}
