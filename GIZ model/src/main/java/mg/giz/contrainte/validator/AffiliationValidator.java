package mg.giz.contrainte.validator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mg.giz.data.constants.ColumnStructure;

public class AffiliationValidator {

	// Filtre les colonnes de type entier affiliation
	public static List<ColumnStructure> getAffiliationColumn(ArrayList<ColumnStructure> columnStructure) {
		List<ColumnStructure> columnAffiliation = columnStructure.stream().filter(c -> c.getType() == 5)
				.collect(Collectors.toList());
		return columnAffiliation;
	}

	// Vérifier les champs de type affiliation
	public static int colAffiliation(File multiparToFile, List<ColumnStructure> columnNumeric) throws IOException {
		FileInputStream fis = new FileInputStream(multiparToFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		int rowCount = mySheet.getLastRowNum() + 1;

		for (int i = 0; i < columnNumeric.size(); i++) {
			int col = columnNumeric.get(i).getIndex();

			for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
				XSSFRow row = mySheet.getRow(rowIndex);
				Cell cell = CellUtil.getCell(row, col);
				String cellVallue = (cell.toString()).toLowerCase().trim();
				if ((!cellVallue.equals("adhérent")) && (!cellVallue.equals("bénéficiaires"))) {
					return col;
				}
			}
		}
		return -1;
	}

}
