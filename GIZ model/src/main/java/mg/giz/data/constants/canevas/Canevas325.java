package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas325 {
	public static Map<String, String> NameTableCanevas325() {
		Map<String, String> NameTableCanevas325 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas325.put("Nom", "personne_nom");
		NameTableCanevas325.put("Code village", "code_fkt");
		NameTableCanevas325.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas325.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas325.put("Genre", "personne_genre");
		NameTableCanevas325.put("Date d'évaluation", "beneficierpgm_date");
		NameTableCanevas325.put("CIN", "personne_cin");
		NameTableCanevas325.put("Adresse", "personne_adresse");
		NameTableCanevas325.put("Contact", "personne_contact");
		return NameTableCanevas325;
	}

}
