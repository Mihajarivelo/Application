package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas1310 {
	public static Map<String, String> NameTableCanevas1310() {
		Map<String, String> NameTableCanevas1310 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas1310.put("Nom propriétaire ferme", "visiteurferme_nom");
		NameTableCanevas1310.put("Code village", "code_fkt");
		NameTableCanevas1310.put("Date d'évaluation", "visiteurferme_date");
		NameTableCanevas1310.put("Nombre visiteurs", "visiteurferme_valeur");
		return NameTableCanevas1310;
	}

}
