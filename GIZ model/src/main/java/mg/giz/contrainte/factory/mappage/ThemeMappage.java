package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class ThemeMappage {
	public static Map<String, Integer> tableTheme(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> ThemeMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			if (NameExcelColumn != null) {
			switch (NameExcelColumn) {
			case "theme_date":
				index = columnStructure.get(i).getIndex();
				ThemeMapping.put("theme_date", index);
				break;
			case "theme_lib":
				index = columnStructure.get(i).getIndex();
				ThemeMapping.put("theme_lib", index);
				break;
			case "theme_programme":
				index = columnStructure.get(i).getIndex();
				ThemeMapping.put("theme_programme", index);
				break;
			case "theme_vslahameau":
				index = columnStructure.get(i).getIndex();
				ThemeMapping.put("theme_vslahameau", index);
				break;
			case "souscomposante_code":
				index = columnStructure.get(i).getIndex();
				ThemeMapping.put("souscomposante_code", index);
				break;
			case "code_fkt":
				index = columnStructure.get(i).getIndex();
				ThemeMapping.put("code_fkt", index);
				break;
			}
		}
		}
		return ThemeMapping;
	}


}
