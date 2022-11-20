package mg.giz.data.constants.canevas;

import java.util.Map;
import java.util.TreeMap;

public class Canevas125c {
	public static Map<String, String> NameTableCanevas125c() {
		Map<String, String> NameTableCanevas125c = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
		NameTableCanevas125c.put("Nom", "personne_nom");
		NameTableCanevas125c.put("Code village", "code_fkt");
		NameTableCanevas125c.put("Année de Naissance", "personne_anneenaiss");
		NameTableCanevas125c.put("Lieu de naissance", "personne_lieunaiss");
		NameTableCanevas125c.put("Genre", "personne_genre");
		NameTableCanevas125c.put("Date de formation", "beneficierpgm_date");
		NameTableCanevas125c.put("CIN", "personne_cin");
		NameTableCanevas125c.put("Adresse", "personne_adresse");
		NameTableCanevas125c.put("Contact", "personne_contact");
		return NameTableCanevas125c;
	}

}
