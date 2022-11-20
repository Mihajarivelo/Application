package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class EcoleeppMappage {
	public static Map<String, Integer> tableEcoleeppMappage(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> EcoleeppMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "ecoleepp_nom":
				index = columnStructure.get(i).getIndex();
				EcoleeppMapping.put("ecoleepp_nom", index);
				break;
			case "code_fkt":
				index = columnStructure.get(i).getIndex();
				EcoleeppMapping.put("code_fkt", index);
				break;
			}
		}
		return EcoleeppMapping;
	}

}
