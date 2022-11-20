package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas1210 {
	public static Map<String, String> NameTableCanevas1210() {
		Map<String, String> NameTableCanevas1210 = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas1210.put("Nom", "personne_nom");
		NameTableCanevas1210.put("Code village", "code_fkt");
		NameTableCanevas1210.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas1210.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas1210.put("Genre", "personne_genre");
		NameTableCanevas1210.put("CIN", "personne_cin");
		NameTableCanevas1210.put("Adresse", "personne_adresse");
		NameTableCanevas1210.put("Contact", "personne_contact");
		return NameTableCanevas1210;
	}

}
