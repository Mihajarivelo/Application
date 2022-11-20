package mg.giz.contrainte.factory.mappage;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import mg.giz.data.constants.ColumnStructure;

public class CyclevslaMappage {
	public static Map<String, Integer> tableCyclevsla(ArrayList<ColumnStructure> columnStructure)
			throws ParseException {
		int index = -1;
		Map<String, Integer> CyclevslaMapping = new HashMap<String, Integer>();

		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();

			switch (NameExcelColumn) {
			case "cyclevsla_lib":
				index = columnStructure.get(i).getIndex();
				CyclevslaMapping.put("cyclevsla_lib", index);
				break;
			}
		}
		return CyclevslaMapping;
	}
}
