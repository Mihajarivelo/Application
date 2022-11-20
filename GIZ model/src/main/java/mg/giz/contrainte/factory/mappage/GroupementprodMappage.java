package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class GroupementprodMappage {
	public static Map<String, Integer> tableGroupementprodMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> groupementprodMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "groupementprod_nom":
				index = columnStructure.get(i).getIndex();
				groupementprodMapping.put("groupementprod_nom", index);
				break;
			case "code_fkt":
				index = columnStructure.get(i).getIndex();
				groupementprodMapping.put("code_fkt", index);
				break;
			case "groupementprod_date":
				index = columnStructure.get(i).getIndex();
				groupementprodMapping.put("groupementprod_date", index);
				break;
			case "groupementprod_service":
				index = columnStructure.get(i).getIndex();
				groupementprodMapping.put("groupementprod_service", index);
				break;
			}

		}

		return groupementprodMapping;
	}

}
