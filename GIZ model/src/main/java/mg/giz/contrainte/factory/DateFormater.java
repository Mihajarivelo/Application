package mg.giz.contrainte.factory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
	private static SimpleDateFormat inSDF = new SimpleDateFormat("dd/mm/yyyy");
	  private static SimpleDateFormat outSDF = new SimpleDateFormat("yyyy-mm-dd");

	  public static String formatDate(String inDate) {
	    String outDate = "";
	    if (inDate != null) {
	        try {
	            Date date = inSDF.parse(inDate);
	            outDate = outSDF.format(date);
	        } catch (ParseException ex){ 
	        }
	    }
	    return outDate;
	  }

	  
}
