package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class MettreoeuvreMappage {
	public static Map<String, Integer> tableMettreoeuvre(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> mettreoeuvreMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "mettreoeuvre_date":
				index = columnStructure.get(i).getIndex();
				mettreoeuvreMapping.put("mettreoeuvre_date", index);
				break;
			}
		}
		return mettreoeuvreMapping;
	}

}
