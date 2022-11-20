package mg.giz.contrainte.validator.upload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

public class UploadValidator {
	private static int rowMax = 50000;
	private static String path = "/data/tomcat/webapps/uploads/";

	// Convertir multipartFile to file
	public static File multipartFileToFile(MultipartFile multipartFile) throws IOException {
		File file = new File(multipartFile.getOriginalFilename());
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream(file);
		fos.write(multipartFile.getBytes());
		fos.close();
		return file;
	}

	// Retourner l'extension du fichier à uploader
	public static String fileExtension(File file) {
		String fileName = file.getName();
		if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
			return fileName.substring(fileName.lastIndexOf(".") + 1);
		else
			return "";
	}

	// Retourner nombre de ligne du fichier
	public static int getRowNumber(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		int rowCount = mySheet.getLastRowNum() + 1;
		return rowCount;
	}

	// Retourner les premiers lignes du fichier
	public static XSSFRow getFirstRow(File file) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		XSSFRow firstRow = null;
		firstRow = mySheet.getRow(0);
		return firstRow;
	}

	// Retourner nombre de ligne et colonne du fichier excel [ligne, colonne]
	public static ArrayList<Integer> getRowColNumber(File file) throws IOException, NullPointerException {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet mySheet = wb.getSheetAt(0);
		XSSFRow row = null;
		row = mySheet.getRow(0);
		int rowCount = mySheet.getLastRowNum() + 1;
		int colCount = row.getLastCellNum();
		numbers.add(rowCount);
		numbers.add(colCount);
		return numbers;
	}

	// Vérifier si l'entete contient des champs vides
	public static ArrayList<Boolean> firstRowIsEmpty(XSSFRow firstRow, int columnCount) throws IOException {
		ArrayList<Boolean> tab = new ArrayList<Boolean>();
		for (int i = 0; i < columnCount; i++) {
			Cell cellValue = firstRow.getCell(i);
			if (cellValue == null || cellValue.getCellType() == Cell.CELL_TYPE_BLANK) {
				tab.add(false);
			} else {
				tab.add(true);
			}
		}
		return tab;
	}

	// Retourner dans une liste les entêtes du fichier
	public static ArrayList<String> getColumnLabel(XSSFRow firstRow, int columnCount) throws IOException {
		ArrayList<String> columnLabel = new ArrayList<String>();
		for (int i = 0; i < columnCount; i = i + 1) {
			Cell cl = firstRow.getCell(i);
			String cellVallue = cl.toString();
			columnLabel.add(cellVallue.trim().replaceAll(" +", " "));
		}
		columnLabel.replaceAll(String::toLowerCase);
		System.out.println(columnLabel);
		return columnLabel;
	}

	// Détection de duplication entête du fichier
	public static Boolean duplicatedColumn(ArrayList<String> list) {
		Set<String> set = new HashSet<String>(list);
		if (set.size() < list.size()) {
			return true;
		} else {
			return false;
		}
	}

	// Vérification avant upload
	public static int beforeUpload(String filename) throws IOException {
		File OriginanFile = new File(path + filename);
		String fileExtension = fileExtension(OriginanFile);
		if (!fileExtension.equals("xlsx")) {
			return 0;
		}
		
		File tempFile = new File(path + "fileUploaded.xlsx");
		if (tempFile.exists()) {
			tempFile.delete();
		}
		
		File filerename = new File(path + filename);
		filerename.renameTo(new File(path + "fileUploaded.xlsx"));
		File file = new File(path + "fileUploaded.xlsx");
		

		int rowCount = getRowNumber(file);
		if (rowCount > rowMax) {
			return 1;
		}

		XSSFRow firstRow = getFirstRow(file);
		if (firstRow == null) {
			return 2;
		}

		ArrayList<Integer> ColCount = getRowColNumber(file);
		int colNumber = ColCount.get(1);
		ArrayList<Boolean> isHeadEmpty = firstRowIsEmpty(firstRow, colNumber);
		if (isHeadEmpty.contains(false)) {
			return 3;
		}

		ArrayList<String> columnName = getColumnLabel(firstRow, colNumber);
		Boolean isDuplicated = duplicatedColumn(columnName);
		if (isDuplicated == true) {
			return 4;
		}

		return -1;
	}

}
