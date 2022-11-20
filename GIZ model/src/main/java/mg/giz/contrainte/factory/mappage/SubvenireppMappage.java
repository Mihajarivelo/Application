package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class SubvenireppMappage {
	public static Map<String, Integer> tableSubvenireppMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> subvenireppMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "subvenirepp_rehabilitation":
				index = columnStructure.get(i).getIndex();
				subvenireppMapping.put("subvenirepp_rehabilitation", index);
				break;
			case "subvenirepp_salaire":
				index = columnStructure.get(i).getIndex();
				subvenireppMapping.put("subvenirepp_salaire", index);
				break;
			case "subvenirepp_fourniture":
				index = columnStructure.get(i).getIndex();
				subvenireppMapping.put("subvenirepp_fourniture", index);
				break;
			case "subvenirepp_ansco":
				index = columnStructure.get(i).getIndex();
				subvenireppMapping.put("subvenirepp_ansco", index);
				break;
			case "subvenirepp_date":
				index = columnStructure.get(i).getIndex();
				subvenireppMapping.put("subvenirepp_date", index);
				break;
			}
		}
		return subvenireppMapping;
	}

}
