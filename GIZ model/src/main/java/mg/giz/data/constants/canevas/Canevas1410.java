package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas1410 {
	public static Map<String, String> NameTableCanevas1410() {
		Map<String, String> NameTableCanevas1410 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas1410.put("Nom leaders groupement de producteurs", "personne_nom");
		NameTableCanevas1410.put("Code village", "code_fkt");
		NameTableCanevas1410.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas1410.put("Genre", "personne_genre");
		NameTableCanevas1410.put("Date d'évaluation", "beneficierpgm_date");
		return NameTableCanevas1410;
	}

}
