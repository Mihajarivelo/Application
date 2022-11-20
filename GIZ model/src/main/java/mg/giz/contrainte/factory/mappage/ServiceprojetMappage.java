package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class ServiceprojetMappage {
	public static Map<String, Integer> tableServiceprojet(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> serviceprojetMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "serviceprojet_nom":
				index = columnStructure.get(i).getIndex();
				serviceprojetMapping.put("serviceprojet_nom", index);
				break;
			}
		}
		return serviceprojetMapping;
	}

}
