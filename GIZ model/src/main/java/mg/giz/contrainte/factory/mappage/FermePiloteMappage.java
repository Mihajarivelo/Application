package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class FermePiloteMappage {
	public static Map<String, Integer> tableFermePiloteMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> FermePiloteMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "fermepilote_date":
				index = columnStructure.get(i).getIndex();
				FermePiloteMapping.put("fermepilote_date", index);
				break;
			case "fermepilote_lib":
				index = columnStructure.get(i).getIndex();
				FermePiloteMapping.put("fermepilote_lib", index);
				break;
			}
		}
		return FermePiloteMapping;
	}

}
