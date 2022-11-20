package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class KitmadereMappage {
	public static Map<String, Integer> tableKitmadere(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> kitmadereMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "kitmadere_date":
				index = columnStructure.get(i).getIndex();
				kitmadereMapping.put("kitmadere_date", index);
				break;
			case "kitmadere_observation":
				index = columnStructure.get(i).getIndex();
				kitmadereMapping.put("kitmadere_observation", index);
				break;
			}
		}
		return kitmadereMapping;

	}

}
