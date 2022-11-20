package mg.giz.contrainte.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mg.giz.data.constants.ColumnStructure;

public class VillageValidator {
	public static List<String> verificationfkt(String[][] ExcelToArray, ArrayList<ColumnStructure> columnStructure) {

		List<String> fktList = new ArrayList<String>();
		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();
			if (NameExcelColumn.equals("code_fkt")) {
				int indice_fkt = columnStructure.get(i).getIndex();

				for (int row = 1; row < ExcelToArray.length; row ++) {
					if (ExcelToArray[row][indice_fkt] != null) {
						fktList.add(ExcelToArray[row][indice_fkt].replaceAll("\\s", ""));
					}
				}
				Set<String> fktSet = new HashSet<String>(fktList);
				List<String> listFktUnik = new ArrayList<String>(fktSet);
				listFktUnik.replaceAll(String::toLowerCase);
				return listFktUnik;
			}
		}
		return null;
	}
}
