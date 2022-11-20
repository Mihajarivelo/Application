package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas125b {
	public static Map<String, String> NameTableCanevas125b() {
		Map<String, String> NameTableCanevas125b = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas125b.put("Nom", "personne_nom");
		NameTableCanevas125b.put("Code village", "code_fkt");
		NameTableCanevas125b.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas125b.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas125b.put("Genre", "personne_genre");
		NameTableCanevas125b.put("Date de formation", "beneficierpgm_date");
		NameTableCanevas125b.put("CIN", "personne_cin");
		NameTableCanevas125b.put("Adresse", "personne_adresse");
		NameTableCanevas125b.put("Contact", "personne_contact");
		return NameTableCanevas125b;
	}

}
