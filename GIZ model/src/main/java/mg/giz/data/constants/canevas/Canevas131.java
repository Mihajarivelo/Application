package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas131 {
	public static Map<String, String> NameTableCanevas131() {
		Map<String, String> NameTableCanevas131 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas131.put("Nom ASA", "personne_nom");
		NameTableCanevas131.put("Code village", "code_fkt");
		NameTableCanevas131.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas131.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas131.put("Genre", "personne_genre");
		NameTableCanevas131.put("Date de formation", "historique_date");
		NameTableCanevas131.put("CIN", "personne_cin");
		NameTableCanevas131.put("Adresse", "personne_adresse");
		NameTableCanevas131.put("Contact", "personne_contact");
		return NameTableCanevas131;
	}

}
