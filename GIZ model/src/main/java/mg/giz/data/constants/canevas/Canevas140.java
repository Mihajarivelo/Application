package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas140 {
	public static Map<String, String> NameTableCanevas140() {
		Map<String, String> NameTableCanevas140 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas140.put("Nom", "personne_nom");
		NameTableCanevas140.put("Code village", "code_fkt");
		NameTableCanevas140.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas140.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas140.put("Genre", "personne_genre");
		NameTableCanevas140.put("CIN", "personne_cin");
		NameTableCanevas140.put("Adresse", "personne_adresse");
		NameTableCanevas140.put("Contact", "personne_contact");
		NameTableCanevas140.put("Code prod SYM", "personne_code");
		NameTableCanevas140.put("Date de suivi", "historique_date");
		return NameTableCanevas140;
	}

}
