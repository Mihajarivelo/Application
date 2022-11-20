package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class ConcernerMappage {
	public static Map<String, Integer> tableConcernerMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> concernerMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "concerner_typeecole":
				index = columnStructure.get(i).getIndex();
				concernerMapping.put("concerner_typeecole", index);
				break;
			case "concerner_date":
				index = columnStructure.get(i).getIndex();
				concernerMapping.put("concerner_date", index);
				break;
			}
		}
		return concernerMapping;
	}

}
