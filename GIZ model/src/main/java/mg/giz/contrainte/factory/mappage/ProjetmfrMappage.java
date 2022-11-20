package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class ProjetmfrMappage {
	public static Map<String, Integer> tableProjetmfrMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> projetmfrMappageMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "projetmfr_date":
				index = columnStructure.get(i).getIndex();
				projetmfrMappageMapping.put("projetmfr_date", index);
				break;
			case "projetmfr_promotion":
				index = columnStructure.get(i).getIndex();
				projetmfrMappageMapping.put("projetmfr_promotion", index);
				break;
			case "projetmfr_realisees":
				index = columnStructure.get(i).getIndex();
				projetmfrMappageMapping.put("projetmfr_realisees", index);
				break;
			case "projetmfr_validees":
				index = columnStructure.get(i).getIndex();
				projetmfrMappageMapping.put("projetmfr_validees", index);
				break;
			case "projetmfr_remarque":
				index = columnStructure.get(i).getIndex();
				projetmfrMappageMapping.put("projetmfr_remarque", index);
				break;
			}
		}
		return projetmfrMappageMapping;
	}

}
