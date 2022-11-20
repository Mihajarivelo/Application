package mg.giz.contrainte.validator.register;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;

import mg.giz.contrainte.validator.upload.UploadValidator;
import mg.giz.data.constants.FieldName;

public class ColumnValidator {
	// Liste des column du fichier excel
	public static ArrayList<String> columnExcelField(File file) throws IOException {
		XSSFRow firstRow = UploadValidator.getFirstRow(file);
		ArrayList<Integer> ColCount = UploadValidator.getRowColNumber(file);
		int colNumber = ColCount.get(1);
		ArrayList<String> excelField = UploadValidator.getColumnLabel(firstRow, colNumber);
		return excelField;
	}

	// Vérifier si toutes les colonnes obligatoires sont présentes
	public static Boolean compareExcelcolToObligatory(List<String> listObligatory, ArrayList<String> columnLabel) {
		System.out.println(listObligatory);
		if (columnLabel.containsAll(listObligatory)) {
			return true;
		} else {
			return false;
		}
	}

	// Vérification des champs optionnels
	public static Boolean compareExcelcolToOptional(List<String> listOptional, ArrayList<String> columnLabel) {
		if (listOptional.containsAll(columnLabel)) {
			return true;
		} else {
			return false;
		}
	}

	// Vérification excel avant enregistrement dans la base de données
	public static int beforeRegister(ArrayList<String> columnLabelExcel, String theme) throws IOException {
		List<String> requiredFieldTheme = FieldName.requiredField(theme);
		List<String> allFieldTheme = FieldName.allFieldTheme(theme);
		//ArrayList<String> excelField = FileValidation.columnExcelField(file);

		Boolean isCompleteObligatory = compareExcelcolToObligatory(requiredFieldTheme, columnLabelExcel);
		if (isCompleteObligatory == false) {
			return 0;
		}

		Boolean isCompleteOptional = compareExcelcolToOptional(allFieldTheme, columnLabelExcel);
		if (isCompleteOptional == false) {
			return 1;
		}

		return -1;
	}

}
