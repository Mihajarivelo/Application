package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas141 {
	public static Map<String, String> NameTableCanevas141() {
		Map<String, String> NameTableCanevas141 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas141.put("Nom groupement", "groupementprod_nom");
		NameTableCanevas141.put("Code village", "code_fkt");
		NameTableCanevas141.put("Date de suivi", "groupementprod_date");
		NameTableCanevas141.put("Service/Projet", "groupementprod_service");
		return NameTableCanevas141;
	}

}
