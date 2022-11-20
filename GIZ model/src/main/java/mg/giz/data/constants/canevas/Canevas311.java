package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas311 {
	public static Map<String, String> NameTableCanevas311() {
		Map<String, String> NameTableCanevas311 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas311.put("Nom", "personne_nom");
		NameTableCanevas311.put("Code village", "code_fkt");
		NameTableCanevas311.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas311.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas311.put("Genre", "personne_genre");
		NameTableCanevas311.put("Date bénéficiaire grants", "beneficierpgm_date");
		NameTableCanevas311.put("CIN", "personne_cin");
		NameTableCanevas311.put("Adresse", "personne_adresse");
		NameTableCanevas311.put("Contact", "personne_contact");
		return NameTableCanevas311;
	}

}
