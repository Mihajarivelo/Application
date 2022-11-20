package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class HistoriqueMappage {

	public static Map<String, Integer> tableHistoriqueMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> HistoriqueMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "historique_date":
				index = columnStructure.get(i).getIndex();
				HistoriqueMapping.put("historique_date", index);
				break;
			}
		}
		return HistoriqueMapping;
	}

}
