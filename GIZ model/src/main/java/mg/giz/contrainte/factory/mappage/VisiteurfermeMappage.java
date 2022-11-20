package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class VisiteurfermeMappage {
	public static Map<String, Integer> tableVisiteurfermeMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> visiteurfermeMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "visiteurferme_nom":
				index = columnStructure.get(i).getIndex();
				visiteurfermeMapping.put("visiteurferme_nom", index);
				break;
			case "code_fkt":
				index = columnStructure.get(i).getIndex();
				visiteurfermeMapping.put("code_fkt", index);
				break;
			case "visiteurferme_date":
				index = columnStructure.get(i).getIndex();
				visiteurfermeMapping.put("visiteurferme_date", index);
				break;
			case "visiteurferme_valeur":
				index = columnStructure.get(i).getIndex();
				visiteurfermeMapping.put("visiteurferme_valeur", index);
				break;
			}
		}
		return visiteurfermeMapping;
	}

}
