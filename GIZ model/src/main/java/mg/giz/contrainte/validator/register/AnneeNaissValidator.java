package mg.giz.contrainte.validator.register;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;

public class AnneeNaissValidator {
	private static int minYear = -1;
	static int year = Calendar.getInstance().get(Calendar.YEAR);

	public static Boolean isYearValid(Cell cell) {

		if ((cell.getCellType() != Cell.CELL_TYPE_NUMERIC)) {
			return false;
		}

		else if (HSSFDateUtil.isCellDateFormatted(cell)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				String cellValue = sdf.format(cell.getDateCellValue());
				String[] dateParts = cellValue.split("/");
				String years = dateParts[2];

				int valueDateNaiss = Integer.parseInt(years);
				if ((minYear < valueDateNaiss) && (valueDateNaiss <= year)) {
					return true;
				} else {
					return false;
				}
			} catch (Exception e) {
				return false;
			}
		}

		else {
			try {
				String cellVallue = (cell.toString()).toLowerCase();
				double valueDateNaiss = Double.valueOf(cellVallue);
				int year = Calendar.getInstance().get(Calendar.YEAR);
				if ((minYear < valueDateNaiss) && (valueDateNaiss <= year)) {
					return true;
				}

			} catch (Exception e) {
				return false;
			}
		}
		return false;
	}

}
