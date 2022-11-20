package mg.giz.contrainte.factory;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ConvertExcelToArray {

	public static String[][] excelToArray(File xlsxFile, int rowCount, int colCount) throws Exception {
		String tab[][] = new String[rowCount][colCount];
		FileInputStream fileInStream = new FileInputStream(xlsxFile);
		XSSFWorkbook wb = new XSSFWorkbook(fileInStream);
		XSSFSheet mySheet = wb.getSheetAt(0);

		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				XSSFRow rowIterator = mySheet.getRow(row);
				Cell cell = CellUtil.getCell(rowIterator, col);

				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					tab[row][col] = cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String cellValue = sdf.format(cell.getDateCellValue());
					String dateFormated = DateFormater.formatDate(cellValue);
					tab[row][col] = dateFormated;
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && !DateUtil.isCellDateFormatted(cell)) {
					double doubleValue = cell.getNumericCellValue();
					String numberAsString = String.valueOf((int) doubleValue);
					tab[row][col] = numberAsString;
				}
			}
		}
		return tab;
	}

	public static String[][] excelToArray40(File xlsxFile, int rowCount, int colCount) throws Exception {
		String tab[][] = new String[rowCount][colCount];
		FileInputStream fileInStream = new FileInputStream(xlsxFile);
		XSSFWorkbook wb = new XSSFWorkbook(fileInStream);
		XSSFSheet mySheet = wb.getSheetAt(0);

		for (int row = 0; row < rowCount; row++) {
			for (int col = 0; col < colCount; col++) {
				XSSFRow rowIterator = mySheet.getRow(row);
				Cell cell = CellUtil.getCell(rowIterator, col);

				if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
					tab[row][col] = cell.getStringCellValue();
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String cellValue = sdf.format(cell.getDateCellValue());
					String dateFormated = DateFormater.formatDate(cellValue);
					tab[row][col] = dateFormated;
				} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC && !DateUtil.isCellDateFormatted(cell)) {
					if (cell.getCellStyle().getDataFormatString().contains("%")) {
						Double doubleValue = cell.getNumericCellValue() * 100;
						tab[row][col] = Double.toString(doubleValue);
					} else {
						double doubleValue = cell.getNumericCellValue();
						tab[row][col] = Double.toString(doubleValue);

					}
				}
			}
			
		}
		return tab;
	}
}
