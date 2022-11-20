package mg.giz.contrainte.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import mg.giz.data.constants.ColumnStructure;

public class GroupementprodValidator {
	public static List<String> verificationGroupementprod(String[][] ExcelToArray, ArrayList<ColumnStructure> columnStructure) {

		List<String> groupementprodList = new ArrayList<String>();
		for (int i = 0; i < columnStructure.size(); i++) {
			String NameExcelColumn = columnStructure.get(i).getNom_champ();
			if (NameExcelColumn.equals("groupementprod_nom")) {
				int indice = columnStructure.get(i).getIndex();

				for (int row = 1; row < ExcelToArray.length; row++) {
					if (ExcelToArray[row][indice] != null) {
						groupementprodList.add(ExcelToArray[row][indice]);
					}
				}
				Set<String> grpSet = new HashSet<String>(groupementprodList);
				List<String> listGroupementprodUnik = new ArrayList<String>(grpSet);
				listGroupementprodUnik.replaceAll(String::toLowerCase);
				return listGroupementprodUnik;
			}
		}
		return null;
	}

}
