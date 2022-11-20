package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class NombreeleveMappage {
	
	public static Map<String, Integer> tableNombreeleveMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> NombreeleveMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "nombreeleve_garcon":
				index = columnStructure.get(i).getIndex();
				NombreeleveMapping.put("nombreeleve_garcon", index);
				break;
			case "nombreeleve_fille":
				index = columnStructure.get(i).getIndex();
				NombreeleveMapping.put("nombreeleve_fille", index);
				break;
			case "nombreeleve_date":
				index = columnStructure.get(i).getIndex();
				NombreeleveMapping.put("nombreeleve_date", index);
				break;
			case "nombreeleve_valeur":
				index = columnStructure.get(i).getIndex();
				NombreeleveMapping.put("nombreeleve_valeur", index);
				break;
			}
		}
		return NombreeleveMapping;
	}

}
