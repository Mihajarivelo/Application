package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas33a {
	public static Map<String, String> NameTableCanevas33a() {
		Map<String, String> NameTableCanevas33a = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas33a.put("Nom champions", "personne_nom");
		NameTableCanevas33a.put("Code village", "code_fkt");
		NameTableCanevas33a.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas33a.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas33a.put("Genre", "personne_genre");
		NameTableCanevas33a.put("Date de suivi", "historique_date");
		NameTableCanevas33a.put("CIN", "personne_cin");
		NameTableCanevas33a.put("Adresse", "personne_adresse");
		NameTableCanevas33a.put("Contact", "personne_contact");
		return NameTableCanevas33a;
	}

}
