package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas132 {
	public static Map<String, String> NameTableCanevas132() {
		Map<String, String> NameTableCanevas132 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas132.put("Nom ASA", "personne_nom");
		NameTableCanevas132.put("Code village", "code_fkt");
		NameTableCanevas132.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas132.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas132.put("Genre", "personne_genre");
		NameTableCanevas132.put("Date d'évaluation", "historique_date");
		NameTableCanevas132.put("CIN", "personne_cin");
		NameTableCanevas132.put("Adresse", "personne_adresse");
		NameTableCanevas132.put("Contact", "personne_contact");
		return NameTableCanevas132;
	}

}
