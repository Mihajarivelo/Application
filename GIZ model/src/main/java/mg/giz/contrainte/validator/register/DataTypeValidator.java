package mg.giz.contrainte.validator.register;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import mg.giz.contrainte.validator.AffiliationValidator;
import mg.giz.contrainte.validator.BinaryValidator;
import mg.giz.contrainte.validator.upload.SpeculationValidator;
import mg.giz.data.constants.ColumnStructure;
import mg.giz.data.constants.DataType;
import mg.giz.data.constants.FieldName;
import mg.giz.data.constants.canevas.GetCanevas;
import mg.giz.data.constants.canevas.canevas1;

public class DataTypeValidator {
	// Vérifier si un string est un entier ou double positif
	public static boolean isNumericPositif(String strNum) {
		return strNum.matches("\\d+(\\.\\d+)?");
	}

	// Vérification données type date
	public static boolean DateValidation(String date) {
		DateFormat format = new SimpleDateFormat("dd/mm/yyyy");
		format.setLenient(false);
		try {
			format.parse(date);
		} catch (ParseException e) {
			return false;
		}
		return true;
	}

	// Retourner les caractéristique de chaque colonne (nom, Obligatoire, index,
	// type)
	public static ArrayList<ColumnStructure> columnStructure(ArrayList<String> columnLabel, String theme) {
		ArrayList<ColumnStructure> columnStructure = new ArrayList<ColumnStructure>();
		List<String> columnProgramObligatory = FieldName.requiredField(theme);
		for (int i = 0; i < columnLabel.size(); i = i + 1) {
			String nom = (columnLabel.get(i)).toLowerCase();
			Boolean Obligatory = true;

			if (columnProgramObligatory.contains(nom)) {
				Obligatory = true;
			} else {
				Obligatory = false;
			}

			int index = i;
			int type = 0;
			try {
				type = DataType.typeColumn(nom);
			} catch (Exception e) {
				type = 2;
			}

			Map<String, String> nom_champ = GetCanevas.getCanevas(theme);
			String champTable = nom_champ.get(nom);

			ColumnStructure cl = new ColumnStructure(nom, champTable, Obligatory, index, type);
			columnStructure.add(cl);
		}
		return columnStructure;
	}

	// Filtrer les colonnes obligatoires
	public static List<ColumnStructure> getObligatoryColumn(ArrayList<ColumnStructure> columnStructure) {
		List<ColumnStructure> columnObligatory = columnStructure.stream().filter(c -> c.getObligatory() == true)
				.collect(Collectors.toList());
		return columnObligatory;
	}

	// Vérifier si les champs obligatoires contiennent des cellules vides
	public static ArrayList<Integer> colObligatoryEmpty(File multiparToFile, List<ColumnStructure> columnObligatory)
			throws IOException {
		ArrayList<Integer> ColBlank = new ArrayList<Integer>();
		FileInputStream fis = new FileInputStream(multiparToFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		int rowCount = mySheet.getLastRowNum() + 1;

		for (int i = 0; i < columnObligatory.size(); i++) {
			int col = columnObligatory.get(i).getIndex();

			for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
				XSSFRow row = mySheet.getRow(rowIndex);
				Cell cell = CellUtil.getCell(row, col);
				if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK) {
					ColBlank.add(col);
				}
			}
		}
		return ColBlank;
	}

	// Récupération des types de valeurs existant dans le fichier
	public static Set<Integer> typeColumn(ArrayList<ColumnStructure> columnStructure) {
		List<Integer> listType = new ArrayList<Integer>();
		for (int i = 0; i < columnStructure.size(); i++) {
			int type = columnStructure.get(i).getType();
			listType.add(type);
		}
		Set<Integer> typeColumn = new HashSet<Integer>(listType);
		return typeColumn;
	}

	// Filtre les colonnes de type entier positif
	public static List<ColumnStructure> getNumericColumn(ArrayList<ColumnStructure> columnStructure) {
		List<ColumnStructure> columnNumeric = columnStructure.stream().filter(c -> c.getType() == 0)
				.collect(Collectors.toList());
		return columnNumeric;
	}

	// Filtre les colonnes de type date
	public static List<ColumnStructure> getDateColumn(ArrayList<ColumnStructure> columnStructure) {
		List<ColumnStructure> columnDate = columnStructure.stream().filter(c -> c.getType() == 1)
				.collect(Collectors.toList());
		return columnDate;
	}

	// Filtre les colonnes genre
	public static List<ColumnStructure> getGenreColumn(ArrayList<ColumnStructure> columnStructure) {
		List<ColumnStructure> columnGenre = columnStructure.stream().filter(c -> c.getType() == 3)
				.collect(Collectors.toList());
		return columnGenre;
	}

	// Filtre les colonnes annee naissance
	public static List<ColumnStructure> getYearNaissColumn(ArrayList<ColumnStructure> columnStructure) {
		List<ColumnStructure> columnYearNaiss = columnStructure.stream().filter(c -> c.getType() == 4)
				.collect(Collectors.toList());
		return columnYearNaiss;
	}

	// Vérifier les champs de type entier positif
	public static int colInteger(File multiparToFile, List<ColumnStructure> columnNumeric) throws IOException {
		FileInputStream fis = new FileInputStream(multiparToFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		int rowCount = mySheet.getLastRowNum() + 1;

		for (int i = 0; i < columnNumeric.size(); i++) {
			int col = columnNumeric.get(i).getIndex();

			for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
				XSSFRow row = mySheet.getRow(rowIndex);
				Cell cell = CellUtil.getCell(row, col);
				String cellVallue = cell.toString();
				boolean isNumeric = isNumericPositif(cellVallue);
				if ((isNumeric == false) && (cell.getCellType() != Cell.CELL_TYPE_BLANK)) {
					return rowIndex;
				}
			}
		}
		return -1;
	}

	// Vérifier les champs de type date
	public static int DateValidation(File multiparToFile, List<ColumnStructure> columnDate) throws IOException {
		FileInputStream fis = new FileInputStream(multiparToFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		int rowCount = mySheet.getLastRowNum() + 1;

		for (int i = 0; i < columnDate.size(); i++) {
			int col = columnDate.get(i).getIndex();
			for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
				XSSFRow row = mySheet.getRow(rowIndex);
				if (CellUtil.getCell(row, col).getCellType() == Cell.CELL_TYPE_NUMERIC
						&& DateUtil.isCellDateFormatted(CellUtil.getCell(row, col))) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
					String cellValue = sdf.format(CellUtil.getCell(row, col).getDateCellValue());
					boolean isValidDate = DateValidation(cellValue);
					if (isValidDate == false) {
						return rowIndex;
					}
				} else {
					return rowIndex;
				}
			}
		}
		return -1;
	}

	// Vérifier les champs de type genre
	public static int colGenre(File multiparToFile, List<ColumnStructure> columnNumeric) throws IOException {
		FileInputStream fis = new FileInputStream(multiparToFile);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		int rowCount = mySheet.getLastRowNum() + 1;

		for (int i = 0; i < columnNumeric.size(); i++) {
			int col = columnNumeric.get(i).getIndex();

			for (int rowIndex = 1; rowIndex < rowCount; rowIndex++) {
				XSSFRow row = mySheet.getRow(rowIndex);
				Cell cell = CellUtil.getCell(row, col);
				String cellVallue = (cell.toString()).trim().toLowerCase();
				if ((!cellVallue.equals("h")) && (!cellVallue.equals("f"))) {
					return col;
				}
			}
		}
		return -1;
	}

	// Vérifier les champs de type annee de naissance
	public static int colYearNaiss(File multiparToFile, List<ColumnStructure> columnNumeric) throws IOException {
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
				Boolean isYearValid = AnneeNaissValidator.isYearValid(cell);
				if (isYearValid == false && (!cellVallue.isEmpty())) {
					return rowIndex;
				}
			}
		}
		return -1;
	}

	// Validation des données
	public static List <Integer> dataValidation(File file, ArrayList<ColumnStructure> columnStructure, String theme)
			throws IOException {
		List<ColumnStructure> colStructureObligatory = getObligatoryColumn(columnStructure);

		try {
			ArrayList<Integer> ColBlank = colObligatoryEmpty(file, colStructureObligatory);
			if (!ColBlank.isEmpty()) {
				return Arrays.asList(0);
			}
		} catch (Exception e) {

			return Arrays.asList(0);
		}

		Set<Integer> typeColumn = typeColumn(columnStructure);

		for (int type : typeColumn) {
			if (type == 0) {
				List<ColumnStructure> columnNumeric = getNumericColumn(columnStructure);
				int colInteger = colInteger(file, columnNumeric);
				if (colInteger != -1) {
					return Arrays.asList(1, colInteger + 1);
				}
			} else if (type == 1) {
				List<ColumnStructure> columnDate = getDateColumn(columnStructure);
				int colDate = DateValidation(file, columnDate);
				if (colDate != -1) {
					return Arrays.asList(2, colDate + 1);
				}
			} else if (type == 3) {
				List<ColumnStructure> columnGenre = getGenreColumn(columnStructure);
				int colGenre = colGenre(file, columnGenre);
				if (colGenre != -1) {
					return Arrays.asList(3);
				}
			} else if (type == 4) {
				List<ColumnStructure> columnYearNaiss = getYearNaissColumn(columnStructure);
				int colYearNaiss = colYearNaiss(file, columnYearNaiss);
				if (colYearNaiss != -1) {
					return Arrays.asList(4, colYearNaiss + 1);
				}
			} else if (type == 5) {
				List<ColumnStructure> columnAffiliation = AffiliationValidator.getAffiliationColumn(columnStructure);
				int colAffiliation = AffiliationValidator.colAffiliation(file, columnAffiliation);
				if (colAffiliation != -1) {
					return Arrays.asList(5);
				}
			} else if (type == 6) {
				List<ColumnStructure> columnBinary = BinaryValidator.getBinaryColumn(columnStructure);
				int colBinary = BinaryValidator.colBinary(file, columnBinary);
				if (colBinary != -1) {
					return Arrays.asList(6);
				}
			}

			else if (type == 7) {
				List<ColumnStructure> columnSpeculation = SpeculationValidator.getSpeculationColumn(columnStructure);
				int colSpeculation = SpeculationValidator.colSpeculation(file, columnSpeculation);
				if (colSpeculation != -1) {
					return Arrays.asList(6);
				}
			}

			
		}
		return Arrays.asList(-1);
	}
}
