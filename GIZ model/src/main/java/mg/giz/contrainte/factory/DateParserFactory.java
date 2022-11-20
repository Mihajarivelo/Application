package mg.giz.contrainte.factory;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateParserFactory {
	public static String formatDate(String dateInput) throws ParseException {
		DateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
		DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date strDate = inputFormat.parse(dateInput);
		String outputText = outputFormat.format(strDate);
		return outputText;
	}
	
	public static String formatDateInverse(String dateInput) throws ParseException {
		DateFormat  inputFormat= new SimpleDateFormat("yyyy-MM-dd");
		DateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
		Date strDate = inputFormat.parse(dateInput);
		String outputText = outputFormat.format(strDate);
		return outputText;
	}

}
