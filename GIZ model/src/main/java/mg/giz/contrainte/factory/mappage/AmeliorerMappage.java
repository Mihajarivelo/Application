package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class AmeliorerMappage {
	public static Map<String, Integer> tableAmeliorer(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer>  ameliorerMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "code_fkt":
				index = columnStructure.get(i).getIndex();
				ameliorerMapping.put("code_fkt", index);
				break;
			case "eaupotable_observation":
				index = columnStructure.get(i).getIndex();
				ameliorerMapping.put("eaupotable_observation", index);
				break;
			case "eaupotable_date":
				index = columnStructure.get(i).getIndex();
				ameliorerMapping.put("eaupotable_date", index);
				break;
			}
		}
		return ameliorerMapping;

	}


}
