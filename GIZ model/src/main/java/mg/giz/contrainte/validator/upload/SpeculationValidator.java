package mg.giz.contrainte.validator.upload;

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

public class SpeculationValidator {
	// Filtre les colonnes de type spéculation
	public static List<ColumnStructure> getSpeculationColumn(ArrayList<ColumnStructure> columnStructure) {
		List<ColumnStructure> columnSpeculation = columnStructure.stream().filter(c -> c.getType() == 7)
				.collect(Collectors.toList());
		return columnSpeculation;
	}

	// Vérifier les champs de type spéculation
	public static int colSpeculation(File multiparToFile, List<ColumnStructure> columnNumeric) throws IOException {
		FileInputStream fis = new FileInputStream(multiparToFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		int rowCount = mySheet.getLastRowNum() + 1;

		for (int i = 0; i < columnNumeric.size(); i++) {
			int col = columnNumeric.get(i).getIndex();

			for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
				XSSFRow row = mySheet.getRow(rowIndex);
				Cell cell = CellUtil.getCell(row, col);
				String cellVallue = (cell.toString()).toLowerCase();
				if ((!cellVallue.equals("vanille")) && (!cellVallue.equals("cacao")) && (!cellVallue.equals("girofle"))
						&& (!cellVallue.equals("agc")) && (!cellVallue.equals(""))) {
					return col;
				}
			}
		}
		return -1;
	}

}
