package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class KitmaderaMappage {
	public static Map<String, Integer> tableKitmaderaMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> KitmaderaMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "enseignantepp_adresse":
				index = columnStructure.get(i).getIndex();
				KitmaderaMapping.put("enseignantepp_adresse", index);
				break;
			case "enseignantepp_classe":
				index = columnStructure.get(i).getIndex();
				KitmaderaMapping.put("enseignantepp_classe", index);
				break;
			case "enseignantepp_contact":
				index = columnStructure.get(i).getIndex();
				KitmaderaMapping.put("enseignantepp_contact", index);
				break;
			case "enseignantepp_fonction":
				index = columnStructure.get(i).getIndex();
				KitmaderaMapping.put("enseignantepp_fonction", index);
				break;
			case "enseignantepp_genre":
				index = columnStructure.get(i).getIndex();
				KitmaderaMapping.put("enseignantepp_genre", index);
				break;
			case "enseignantepp_nom":
				index = columnStructure.get(i).getIndex();
				KitmaderaMapping.put("enseignantepp_nom", index);
				break;
			case "kitmadere_date":
				index = columnStructure.get(i).getIndex();
				KitmaderaMapping.put("kitmadere_date", index);
				break;
			}
		}
		return KitmaderaMapping;
	}

}
