package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class OtivMappage {
	public static Map<String, Integer> tableOtivMappage(ArrayList<ColumnStructure> columnStructure) throws ParseException {
		int index = -1;
		Map<String, Integer> otivMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();
			switch (NameExcelColumn) {
			case "otiv_code":
				index = columnStructure.get(i).getIndex();
				otivMapping.put("otiv_code", index);
				break;
			}

		}
		return otivMapping;

	}
}
