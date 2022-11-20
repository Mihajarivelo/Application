package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas3210 {
	public static Map<String, String> NameTableCanevas3210() {
		Map<String, String> NameTableCanevas3210 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas3210.put("Nom", "personne_nom");
		NameTableCanevas3210.put("Code village", "code_fkt");
		NameTableCanevas3210.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas3210.put("Genre", "personne_genre");
		NameTableCanevas3210.put("Date d'adhésion", "beneficierpgm_date");
		NameTableCanevas3210.put("Leader comité de jeunes", "beneficierpgm_valeur");
		return NameTableCanevas3210;
	}

}
